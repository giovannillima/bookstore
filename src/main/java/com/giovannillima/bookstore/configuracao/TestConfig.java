package com.giovannillima.bookstore.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.giovannillima.bookstore.service.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService dbservice;
	
	@Bean
	public Boolean instanciaDb() {
		this.dbservice.instanciaDb();
		return true;
	}

}
