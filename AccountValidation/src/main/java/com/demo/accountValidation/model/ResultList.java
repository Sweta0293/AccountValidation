package com.demo.accountValidation.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class ResultList {
	private ArrayList<Result> result;

	public ArrayList<Result> getResult() {
		return result;
	}

	public void setResult(ArrayList<Result> result) {
		this.result = result;
	}
}
