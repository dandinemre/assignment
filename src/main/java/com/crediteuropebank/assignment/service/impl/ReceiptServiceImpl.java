package com.crediteuropebank.assignment.service.impl;

import com.crediteuropebank.assignment.model.Receipt;
import com.crediteuropebank.assignment.repository.ReceiptRepository;
import com.crediteuropebank.assignment.service.IngredientService;
import com.crediteuropebank.assignment.service.InstructionService;
import com.crediteuropebank.assignment.service.ReceiptService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final static Logger logger = LoggerFactory.getLogger(ReceiptServiceImpl.class);

    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    InstructionService instructionService;

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(setReceiptsToIngredientsAndInstructions(receipt));
    }

    @Override
    @Transactional
    public void update(Receipt receipt, Long receiptId) {
         receiptRepository.findById(receiptId).map(fetchedReceipt -> {
            fetchedReceipt.setName(receipt.getName());
            fetchedReceipt.setVegetarian(receipt.getVegetarian());
            fetchedReceipt.setPortion(receipt.getPortion());
            setIngredientsToReceipt(clearFetchedReceiptsIngredients(fetchedReceipt),receipt);
            setInstructionsToReceipt(clearFetchedReceiptsInstructions(fetchedReceipt),receipt);
            return receiptRepository.save(fetchedReceipt);
        });
    }

    @Override
    public void delete(Long receiptId) {
        receiptRepository.deleteById(receiptId);
    }

    @Override
    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    private Receipt clearFetchedReceiptsIngredients(Receipt fetchedReceipt) {
        ingredientService.deleteByReceiptId(fetchedReceipt.getId());

        return fetchedReceipt;
    }

    private Receipt clearFetchedReceiptsInstructions(Receipt fetchedReceipt) {
        instructionService.deleteByReceiptId(fetchedReceipt.getId());

        return fetchedReceipt;
    }

    private void setIngredientsToReceipt(Receipt fetchedReceipt, Receipt receipt) {
        AtomicInteger counter = new AtomicInteger(0);

        receipt.getIngredients().stream().forEach(ingredient -> {
            ingredient.setReceipt(fetchedReceipt);
            ingredient.setOrder(counter.incrementAndGet());
        });

        fetchedReceipt.setIngredients(receipt.getIngredients());
    }

    private void setInstructionsToReceipt(Receipt fetchedReceipt, Receipt receipt) {
        AtomicInteger counter = new AtomicInteger(0);

        receipt.getInstructions().stream().forEach(instruction -> {
            instruction.setReceipt(fetchedReceipt);
            instruction.setOrder(counter.incrementAndGet());
        });
        fetchedReceipt.setInstructions(receipt.getInstructions());
    }

    private Receipt setReceiptsToIngredientsAndInstructions(Receipt receipt) {
        AtomicInteger counter = new AtomicInteger(0);

        receipt.getIngredients().stream().forEach(ingredient -> {
            ingredient.setReceipt(receipt);
            ingredient.setOrder(counter.incrementAndGet());
        });
        counter.set(0);
        receipt.getInstructions().stream().forEach(instruction -> {
            instruction.setReceipt(receipt);
            instruction.setOrder(counter.incrementAndGet());
        });
        try {
            Date myDate = receipt.getCreatedDate();
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String strDate = sm.format(myDate);
            Date dt = sm.parse(strDate);
            receipt.setCreatedDate(dt);
        } catch (ParseException parseException) {

        }
        return receipt;
    }
}
