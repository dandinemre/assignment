package com.crediteuropebank.assignment.controller;

import com.crediteuropebank.assignment.model.Receipt;
import com.crediteuropebank.assignment.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @PostMapping()
    public void save(@RequestBody Receipt receipt){
        receiptService.save(receipt);
    }

    @GetMapping()
    public Collection<Receipt> getAll() {
        return receiptService.findAll();
    }

    @DeleteMapping("/{receiptId}")
    public void delete(@PathVariable Long receiptId) {
        receiptService.delete(receiptId);
    }

    @PutMapping("/{receiptId}")
    public void update(@RequestBody Receipt receipt, @PathVariable Long receiptId) {
        receiptService.update(receipt, receiptId);
    }

}
