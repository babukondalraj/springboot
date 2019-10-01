package com.sis.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/staticfilter1")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("Value1","Value2","Value3");
	}
	
	@GetMapping("/staticfilter2")
	public SomeBean2 retrieveSomeBean2() {
		return new SomeBean2("Java","Angular","React");
	}

	@GetMapping("/dynamicfilter1")
	public MappingJacksonValue retrieveSomeBean3() {
		SomeBean3 bean = new SomeBean3("Dyanamic 1","Dyanamic 2","Dyanamic 3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filterProvider);

		return mapping;
	}
}
