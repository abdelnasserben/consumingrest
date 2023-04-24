package com.dabel.consumingrest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "com.dabel.consumingrest")
@Data
public class CustomProperties {

	private String apiUrl;
}
