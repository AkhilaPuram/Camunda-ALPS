package com.aaseya.alps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication(scanBasePackages = "com.aaseya.alps")
@ComponentScan("com.aaseya.alps")
@EntityScan( basePackages = "com.aaseya.alps.model" )
@EnableJpaRepositories(basePackages = "com.aaseya.alps.dao")
@Deployment(resources = "/camunda/*.bpmn")
public class AlpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlpsApplication.class, args);
	}

}
