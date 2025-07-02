package com.grossery.grossery.Repository;

import com.grossery.grossery.Model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GroceryRepository extends JpaRepository<GroceryItem, Long> {

    // This class will handle data access operations for the Grossery application.
    // It will interact with the database or any other data source to perform CRUD operations on grocery items, categories, etc.

    GroceryItem findItemById(@Param("id") Long id);
}