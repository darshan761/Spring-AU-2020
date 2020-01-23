package com.springAU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springAU.model.Point;

@Service
public class PointService {
	
	@Autowired
    private Environment environment;
	
    public Point getPoint() {
    	return new Point(Integer.parseInt(environment.getProperty("Point.x")),Integer.parseInt(environment.getProperty("Point.y")));
    }
	
}
