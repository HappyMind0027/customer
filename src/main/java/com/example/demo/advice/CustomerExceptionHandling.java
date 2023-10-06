package com.example.demo.advice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DuplicateDataException;
import com.example.demo.exception.GenericException;
import com.example.demo.pojos.ApiErorr;

@RestControllerAdvice
public class CustomerExceptionHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> error = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(x -> error.put(x.getField(), x.getDefaultMessage()));
		return error;
	}

	@ExceptionHandler(DuplicateDataException.class)
	public ResponseEntity<ApiErorr> handleDuplicateData(DuplicateDataException ex) {
		ApiErorr error = new ApiErorr(901, ex.getMessage(), new Date());
		return new ResponseEntity<ApiErorr>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ApiErorr> handleGenericException(GenericException ex) {
		ApiErorr error = new ApiErorr(902, ex.getMessage(), new Date());
		return new ResponseEntity<ApiErorr>(error, HttpStatus.BAD_REQUEST);
	}
}
