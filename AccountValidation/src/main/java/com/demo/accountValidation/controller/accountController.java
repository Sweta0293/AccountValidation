package com.demo.accountValidation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accountValidation.model.Account;
import com.demo.accountValidation.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class accountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/validate")
	@GetMapping
	public ResponseEntity<Object> accountValidation(@RequestBody @Valid Account account) {
		return accountService.accountValidate(account);
	}

}
