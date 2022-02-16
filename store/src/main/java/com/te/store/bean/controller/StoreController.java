package com.te.store.bean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.store.bean.StoreResponse;
import com.te.store.bean.service.StoreService;

@RestController
@RequestMapping("/info")
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("/fetchall/{storeId}")
	public ResponseEntity<StoreResponse> getAll(@PathVariable String storeId) {
		StoreResponse res = new StoreResponse(false, service.getAll(storeId));
		return new ResponseEntity<StoreResponse>(res, HttpStatus.OK);

	}

	@GetMapping("/fetchbyoption")
	public ResponseEntity<StoreResponse> getByOption(@RequestParam String option) {
		StoreResponse res = new StoreResponse(false, service.getByOption(option));
		return new ResponseEntity<StoreResponse>(res, HttpStatus.OK);
	}
}
