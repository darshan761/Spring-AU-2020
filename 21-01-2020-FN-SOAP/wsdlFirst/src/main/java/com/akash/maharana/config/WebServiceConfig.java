package com.akash.maharana.config;

import javax.xml.ws.Endpoint;



import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akash.maharana.wsdlFirst.CustomerOrdersWSImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endPoint = new EndpointImpl(bus, new CustomerOrdersWSImpl());
		endPoint.publish("/customerordersservice");
		return endPoint;
	}

}
