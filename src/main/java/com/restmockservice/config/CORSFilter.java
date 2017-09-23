package com.restmockservice.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	private String mode = "DENY";
	
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		    HttpServletResponse res = (HttpServletResponse)response;
		    res.addHeader("X-FRAME-OPTIONS", mode );
		    String host = "http://" + request.getServerName() + ":" + request.getServerPort();
		    res.addHeader("host", host);
		    res.addHeader("Access-Control-Allow-Origin", "*");
		    res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept" );
		    chain.doFilter(request, response);
	  }

	  public void destroy() {
	  }

	  public void init(FilterConfig filterConfig) {
	    String configMode = filterConfig.getInitParameter("mode");
	    if ( configMode != null ) {
	      mode = configMode;
	    }
	  }

}
