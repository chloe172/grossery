package com.grossery.grossery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grossery.grossery.Model.GroceryItem;
import com.grossery.grossery.Repository.GroceryRepository;
import com.grossery.grossery.Service.GroceryService;

@SpringBootApplication
@RestController
@RequestMapping("/api/grocery")
public class GroceryApplication {
	// This class will handle the HTTP requests and responses for the grocery application.
    // It will contain methods to manage grocery items, categories, and other related functionalities.
    
	@Autowired
    GroceryService groceryService;
	@Autowired
	GroceryRepository groceryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}

	@Bean
    public CommandLineRunner initData(GroceryRepository groceryRepository) {
        return args -> {
            GroceryItem item = new GroceryItem("Apple", "Fruits", 0.5, 10);
            GroceryItem item2 = new GroceryItem("Banana", "Fruits", 0.3, 20);
            GroceryItem item3 = new GroceryItem("Carrot", "Vegetables", 0.2, 15);
            GroceryItem item4 = new GroceryItem("Bread", "Bakery", 1.0, 5);

            groceryRepository.saveAndFlush(item);
            groceryRepository.saveAndFlush(item2);
            groceryRepository.saveAndFlush(item3);
            groceryRepository.saveAndFlush(item4);
        };
    }
   
    @GetMapping("/items")
    public List<GroceryItem> getAllItems() {
        return groceryService.getAllItems();
    }

}