package com.crediteuropebank.assignment.repository;

import com.crediteuropebank.assignment.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    void deleteByReceiptId(Long receiptId);

}
