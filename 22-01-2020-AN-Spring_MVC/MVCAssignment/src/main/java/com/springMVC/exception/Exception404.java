package com.springMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such page")  // 404
public class Exception404 extends RuntimeException {
	
}
