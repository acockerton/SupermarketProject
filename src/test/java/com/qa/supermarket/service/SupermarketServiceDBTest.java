package com.qa.supermarket.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.supermarket.domain.Supermarket;
import com.qa.supermarket.repo.SupermarketRepo;

@SpringBootTest
@ActiveProfiles("test")
public class SupermarketServiceDBTest {

	
		private Supermarket input;
		private Supermarket returned;

		@Autowired 
		private SupermarketServiceDB serv;

		@MockBean 
		private SupermarketRepo rep;

		@BeforeEach
		void setUp() {

			input = new Supermarket("Milk", 750, "Dairy");
			returned = new Supermarket(1L, "Milk", 750, "Dairy");
		}

		@Test
		void testCreate() {

			Mockito.when(this.rep.save(input)).thenReturn(returned);
		
			assertThat(this.serv.create(input)).isEqualTo(returned);

			Mockito.verify(this.rep, Mockito.times(1)).save(input);
		}

		@Test
		void testRead() {

			List<Supermarket> readList = new ArrayList<>();
			readList.add(input);
	
			Mockito.when(this.rep.findAll()).thenReturn(readList);
		
			assertThat(this.serv.read()).isEqualTo(readList);
			
			Mockito.verify(this.rep, Mockito.times(1)).findAll();
		}

		
		
		@Test
		void testReadOne() {
		
			Long id = 1L;
		
			Optional<Supermarket> optSuper = Optional.of(returned);
			
			Mockito.when(this.rep.findById(id)).thenReturn(optSuper);
	
			assertThat(this.serv.readOne(id)).isEqualTo(returned);
			
			Mockito.verify(this.rep, Mockito.times(1)).findById(id);
		}
		

		@Test
		void testUpdate() {
			
			Long id = 1L;
			
			Supermarket toUpdate = new Supermarket("Porridge", 1000, "Breakfast");
			
			Optional<Supermarket> opt = Optional.of(returned);
			
			Supermarket updated = new Supermarket(id, toUpdate.getItem(), toUpdate.getWeight(), toUpdate.getCategory());
		
			Mockito.when(this.rep.findById(id)).thenReturn(opt);
			Mockito.when(this.rep.save(updated)).thenReturn(updated);
		
//			assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);
		
//			Mockito.verify(this.rep, Mockito.times(1)).findById(id);
//			Mockito.verify(this.rep, Mockito.times(1)).save(updated);
		}

		@Test
		void testDelete() {
		
			Long id = 1L;
			
			Optional<Supermarket> optChoco = Optional.of(returned);
			
			Mockito.when(this.rep.findById(id)).thenReturn(optChoco);
			
			assertThat(this.serv.delete(id)).isEqualTo(returned);
		
			Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
			Mockito.verify(this.rep, Mockito.times(1)).findById(id);
		}

		@Test
		void testRemove() {
			
			Long id = 1L;
		
			Mockito.when(this.rep.existsById(id)).thenReturn(false);
		
			assertThat(this.serv.remove(id)).isTrue();
		
			Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
			Mockito.verify(this.rep, Mockito.times(1)).existsById(id);
		}

		@AfterEach
		void clear() {

		}

	}


