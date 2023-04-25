package com.dabel.consumingrest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * Configure own custom properties in the 
 * application.properties file
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Configuration
@ConfigurationProperties(prefix = "com.dabel.consumingrest")
@Data
public class CustomProperties {

	private String apiUrl;
}
