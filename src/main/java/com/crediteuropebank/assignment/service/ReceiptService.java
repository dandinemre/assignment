package com.crediteuropebank.assignment.service;

import com.crediteuropebank.assignment.model.Receipt;

import java.util.List;

public interface ReceiptService {

    void save(Receipt receipt);

    void delete(Long receiptId);

    List<Receipt> findAll();

    void update(Receipt receipt, Long receiptId);

}
