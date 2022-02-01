package com.david.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadConfig {
	
	@Value("${spring.application.name}")
	private String springApplicationName;
	

	
	@Bean
	public void init() {
		log.info("Spring Application Name spring.application.name {}",springApplicationName);
		log.info("ENV variable SPRING_APPLICATION_NAME {}",System.getenv("SPRING_APPLICATION_NAME"));
	}
	

}
