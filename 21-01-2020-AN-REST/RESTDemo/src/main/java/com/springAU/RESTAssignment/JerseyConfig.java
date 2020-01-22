package com.springAU.RESTAssignment;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(Controller.class);
	}
}
