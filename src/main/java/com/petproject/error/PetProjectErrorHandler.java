package com.petproject.error;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PetProjectErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("status", status.value());

		// Get all fields errors
		List<String> errors = ex.getBindingResult()
				                .getFieldErrors()
				                .stream()
				                .map(x -> getErr(x))
				                .collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		String messages[] = ex.getMessage().split(":|;");
		body.put("status", status.value());
		body.put("errors",  messages[2].trim() + messages[3]);

		return new ResponseEntity<>(body, headers, status);
	}

	public String getErr(FieldError fieldErr) {
		String errMessage = fieldErr.getField() + " " + fieldErr.getDefaultMessage();

		return errMessage;
	}

}
