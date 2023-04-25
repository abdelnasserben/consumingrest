package com.dabel.consumingrest.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Configure specific error pages
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Configuration
public class WebApplicationConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
	}
		
}
