package com.demo.accountValidation.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "datasources")
public class Providers {

	private List<Source> providers;

	public List<Source> getProviders() {
		return providers;
	}

	public void setProviders(List<Source> providers) {
		this.providers = providers;
	}

}
