package com.grossery.grossery.Service;

import com.grossery.grossery.Model.GroceryItem;
import com.grossery.grossery.Repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroceryService {
    @Autowired
    private GroceryRepository groceryRepository;
    // This class will contain the business logic for the Grocery application.
    // It will interact with the data layer to perform operations related to grocery items, categories, etc.

    public List<GroceryItem> getAllItems() {
        return groceryRepository.findAll();
    }

}