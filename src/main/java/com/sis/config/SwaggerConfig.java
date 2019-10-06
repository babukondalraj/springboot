package com.sis.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final static Set<String> DEFAULT_PRODUCE_AND_CONSUME =
			new HashSet<String>();
	static {
		DEFAULT_PRODUCE_AND_CONSUME.add("application/json");
		DEFAULT_PRODUCE_AND_CONSUME.add("application/xml");
	}

	
	
	
//	Arrays.asList("application/json", "application/xml")

	
	///List<String> names = Arrays.asList("");
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				//.apis(RequestHandlerSelectors.basePackage("com.babu.controller"))
				.build().apiInfo(apiInfo()).produces(DEFAULT_PRODUCE_AND_CONSUME).consumes(DEFAULT_PRODUCE_AND_CONSUME);

	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Task App", "To Main the Task", "API TOS", "Terms of Service",
				new Contact("Babu Kondalraj", "www.taskapp.com", "babu@tasdk.com"), "License of API",
				"URL for Task App", Collections.EMPTY_LIST);
	}
}