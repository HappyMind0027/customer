package com.example.demo.exception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericException(String mesg) {
		super(mesg);
	}

}