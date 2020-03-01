package com.test.asellion;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration implements Filter {

	private FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		MultiReadHttpServletRequest requestWrapper=new MultiReadHttpServletRequest(request);
		chain.doFilter(requestWrapper,res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

}
