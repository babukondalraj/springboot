package com.sis.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/hey")
	public String hey(@RequestParam(required=false, defaultValue="Babu") String name) {
		return String.format("Hey ! %s", name);
	}

	@GetMapping("/hello")
	public String greeting(@RequestHeader(name="Accept-Language", defaultValue="US", required=false)Locale locale, @RequestParam(name="name") String id) {
		System.out.println("1234" + locale);
		System.out.println(messageSource.getMessage("good.morning.message", null, locale));
		return String.format("%s %s",messageSource.getMessage("good.morning.message", null, locale) ,id);
	}

	@GetMapping("/bye")
	public String bye(@RequestParam(name="name") String id) {
		System.out.println(messageSource.getMessage("good.bye.message", null, LocaleContextHolder.getLocale()));
		return String.format("%s %s",messageSource.getMessage("good.bye.message", null, LocaleContextHolder.getLocale()) ,id);
	}
	
}
