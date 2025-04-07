package com.ibs_item_service.item_service;

import com.ibs_item_service.item_service.entity.Item;
import com.ibs_item_service.item_service.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(@Autowired ItemRepository itemRepository) {
		return args -> {
			itemRepository.save(new Item(null, "Laptop", "High-performance laptop", 1200.00));
			itemRepository.save(new Item(null, "Smartphone", "Latest model smartphone", 800.00));
			itemRepository.save(new Item(null, "Headphones", "Noise-canceling headphones", 150.00));
		};
	}
}
