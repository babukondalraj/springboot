package com.sis.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="db")

public @Data class DBConfigProperties {
	private String username;
}
