package com.te.store.bean.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.store.bean.StoreResponse;
import com.te.store.exception.StoreException;

@RestControllerAdvice
public class StoreControllerAdvice {

	@ExceptionHandler(StoreException.class)
	public ResponseEntity<StoreResponse> exception(StoreException found) {
		StoreResponse response = new StoreResponse(true, found.getMessage());
		return new ResponseEntity<StoreResponse>(response, HttpStatus.NOT_FOUND);
	}

}
