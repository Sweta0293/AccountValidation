package com.demo.accountValidation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.demo.accountValidation.configuration.Source;
import com.demo.accountValidation.configuration.Providers;
import com.demo.accountValidation.model.Account;
import com.demo.accountValidation.model.Result;
import com.demo.accountValidation.model.ResultList;

@Service
public class AccountService {
	@Autowired
	private Providers providers;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ResultList resultList;

	public ResponseEntity<Object> accountValidate(Account account) {
		ArrayList<Result> list = new ArrayList<>();
		if (account.getSources() == null || account.getSources().isEmpty()) {
			for (Source sources : providers.getProviders()) {
				accountCheck(sources.getName(), sources.getUrl(), account.getAccountNumber(), list);
			}
		} else {
			for (String source : account.getSources()) {
				List<Source> config = providers.getProviders().stream()
						.filter(datasource -> datasource.getName().equals(source)).collect(Collectors.toList());
				if (!config.isEmpty()) {
					accountCheck(config.get(0).getName(), config.get(0).getUrl(), account.getAccountNumber(), list);
				}
			}
		}
		resultList.setResult(list);
		return new ResponseEntity<Object>(resultList, HttpStatus.OK);
	}

	public void accountCheck(String name, String url, String accountNumber, ArrayList<Result> list)
			throws RestClientException {
		Boolean isValid = false;
		Result result = new Result();
		result.setSource(name);
		try {
			isValid = restTemplate.getForObject(url, Boolean.class, accountNumber);
		} catch (RestClientException e) {
			throw new RestClientException(e.getMessage());
		}
		result.setIsValid(isValid);
		list.add(result);
	}
}
