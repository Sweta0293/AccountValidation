package com.demo.accountValidation.model;

import org.springframework.stereotype.Component;

@Component
public class Result {
	private String source;
	private Boolean isValid;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
