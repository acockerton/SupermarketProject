package com.qa.supermarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.supermarket.domain.Supermarket;
import com.qa.supermarket.repo.SupermarketRepo;

@Service
public class SupermarketServiceDB implements SupermarketInterface<Long> {
	
	private SupermarketRepo repo;
	
	public SupermarketServiceDB(SupermarketRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Supermarket create(Supermarket x) {
		return this.repo.save(x);
	}

	@Override
	public List<Supermarket> read() {
		return this.repo.findAll();
	}

	public Supermarket readOne(Long id) {
		Optional<Supermarket> optRead = this.repo.findById(id);
		return optRead.orElse(null);
	}
	
	@Override
	public Supermarket update(Long id, Supermarket y) {
		Optional<Supermarket> optSuper = this.repo.findById(id);
		Supermarket found = optSuper.get();
		found.setWeight(y.getWeight());
		found.setItem(y.getItem());
		found.setCategory(y.getCategory());
		return this.repo.save(found);
	}

	@Override
	public Supermarket delete(Long id) {
		Optional<Supermarket> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
