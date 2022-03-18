package com.qa.supermarket.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supermarket {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String item;
	private int weight;
	private String category;
	

	public Supermarket() {
		super();
	}
	

	public Supermarket(Long id, String item, int weight, String category) {
		super();
		this.id = id;
		this.item = item;
		this.weight = weight;
		this.category = category;
	}
	
	public Supermarket(String item, int weight, String category) {
		super();
		this.item = item;
		this.weight = weight;
		this.category = category;
	}

	
	
	public String getItem() {
		return item;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setItem(String name) {
		this.item = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
@Override
public int hashCode() {
	return Objects.hash(weight, item, category, id);
}
	
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Supermarket other = (Supermarket) obj;
	return weight == other.weight && Objects.equals(item, other.item) && Objects.equals(category, other.category)
			&& Objects.equals(id,  other.id);
	
	}
	
	
}
