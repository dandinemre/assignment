package com.crediteuropebank.assignment.service;

import com.crediteuropebank.assignment.model.Receipt;
import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    void save(Receipt receipt);

    void delete(Long receiptId);

    Optional<Receipt> findById(Long receiptId);

    List<Receipt> findAll(Integer pageNum, Integer pageSize, String sortBy);

    void update(Receipt receipt, Long receiptId);

}
