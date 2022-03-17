package com.qa.supermarket.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.supermarket.domain.Supermarket;
import com.qa.supermarket.service.SupermarketServiceDB;

@RestController
public class SupermarketController {

	private SupermarketServiceDB service;
	
	public SupermarketController(SupermarketServiceDB service) {
		super();
		this.service = service;
	}


	@PostMapping("/create")
	public ResponseEntity<Supermarket> createSupermarket(@RequestBody Supermarket a) {
		return new ResponseEntity<Supermarket>(this.service.create(a), HttpStatus.CREATED);
	}
	

	@GetMapping("readAll")
	public List<Supermarket> readSupermarket(){
		return this.service.read();
	}
	

	@GetMapping("/readById/{id}")
	public Supermarket getById(@PathVariable Long id) {
		return this.service.readOne(id);
		
	}
	

	@PutMapping("/update/{id}")
	public Supermarket update(@PathVariable Long id, @RequestBody Supermarket updated) {
		return this.service.update(id, updated);
	}

	
	@DeleteMapping("/delete")
	public Supermarket delete(@PathParam("id") Long id) {
		return this.service.delete(id);
	
}
	@DeleteMapping("/remove")
	public boolean remove(@PathParam("id") Long id) {
		return this.service.remove(id);
	}
}
