package com.sis.controller;

import java.util.Arrays;
import java.util.List;

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
		SomeBean3 someBean3 = new SomeBean3("Dyanamic 1","Dyanamic 2","Dyanamic 3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean3);
		mapping.setFilters(filterProvider);

		return mapping;
	}
	
	
	@GetMapping("/dynamicfilter2")
	public MappingJacksonValue retrieveSomeBean4() {
		List<SomeBean3> list = Arrays.asList(new SomeBean3("Value1", "Value2", "Value3"),
				new SomeBean3("Value21","value22", "value23"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3","field2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);

		return mapping;
	}	
}
