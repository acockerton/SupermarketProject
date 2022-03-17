package com.qa.supermarket.service;

import java.util.List;

import com.qa.supermarket.domain.Supermarket;

public interface SupermarketInterface<T> {
	
	Supermarket create(Supermarket x);
	
	List<Supermarket> read();
	
	Supermarket update(T id, Supermarket y);
	
	Supermarket delete(T id);
	
}
