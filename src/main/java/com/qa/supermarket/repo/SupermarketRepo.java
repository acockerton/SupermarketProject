package com.qa.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.supermarket.domain.Supermarket;

@Repository
public interface SupermarketRepo extends JpaRepository<Supermarket, Long> {


}
