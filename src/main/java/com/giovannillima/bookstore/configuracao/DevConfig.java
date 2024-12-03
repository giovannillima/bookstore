package com.giovannillima.bookstore.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.giovannillima.bookstore.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DbService dbservice;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instanciaDb() {
		if (strategy.equals("create")) {
			this.dbservice.instanciaDb();
		}
		return false;
	}

}
