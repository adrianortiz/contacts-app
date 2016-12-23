package com.codizer.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// Permite realizar operaciones por cada peticion que se realiza

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	// Se ejecuta antes de entrar al metodo controller
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	// Se ejecuta justo antes de devolver la vista del navegador (antes del return de un metodo)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("URL TO: '" + request.getRequestURL().toString() + "' IN: '" + (System.currentTimeMillis() - startTime) + "ms'");
	}
	
}
