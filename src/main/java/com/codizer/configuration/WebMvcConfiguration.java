package com.codizer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.codizer.component.RequestTimeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMvcConfiguration.
 */
// Configuracion para Spring
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	/** The request time interceptor. */
	// Inyectar el Interceptor que esta en la memoria de Spring
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
}
