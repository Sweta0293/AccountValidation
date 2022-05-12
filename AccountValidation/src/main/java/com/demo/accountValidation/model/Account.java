package com.demo.accountValidation.model;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class Account {

	@NotBlank(message = "Account Number is mandatory !!!")
	@Pattern(regexp = "^[0-9]{8}$", message = "Account Number should be of 8 digit !!!")
	private String accountNumber;

	private ArrayList<String> sources;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ArrayList<String> getSources() {
		return sources;
	}

	public void setSources(ArrayList<String> sources) {
		this.sources = sources;
	}

}
