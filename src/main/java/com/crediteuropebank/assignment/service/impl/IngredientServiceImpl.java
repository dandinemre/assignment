package com.crediteuropebank.assignment.service.impl;

import com.crediteuropebank.assignment.repository.IngredientRepository;
import com.crediteuropebank.assignment.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public void delete(Long instructionId) {
        ingredientRepository.deleteById(instructionId);
    }

    @Override
    public void deleteByReceiptId(Long receiptId) {
        ingredientRepository.deleteByReceiptId(receiptId);
    }
}
