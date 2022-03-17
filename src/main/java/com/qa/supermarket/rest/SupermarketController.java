package com.qa.supermarket.rest;

import org.springframework.web.bind.annotation.RestController;


import com.qa.supermarket.service.SupermarketServiceDB;

@RestController
public class SupermarketController {

	private SupermarketServiceDB service;
	
	public SupermarketController(SupermarketServiceDB service) {
		super();
		this.service = service;
	}

}
