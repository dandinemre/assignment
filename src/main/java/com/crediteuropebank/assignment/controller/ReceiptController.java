package com.crediteuropebank.assignment.controller;

import com.crediteuropebank.assignment.model.Receipt;
import com.crediteuropebank.assignment.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receipt")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @PostMapping()
    public void save(@RequestBody Receipt receipt){
        receiptService.save(receipt);
    }

    @GetMapping()
    public ResponseEntity<List<Receipt>> getAll(@RequestParam(defaultValue = "0") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy){
         List<Receipt> list = receiptService.findAll(pageNum,pageSize,sortBy);
         return new ResponseEntity<List<Receipt>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{receiptId}")
    public Optional<Receipt> getById(@PathVariable Long receiptId) {
       return receiptService.findById(receiptId);
    }

    @DeleteMapping("/{receiptId}")
    public void delete(@PathVariable Long receiptId) {
        receiptService.delete(receiptId);
    }

    @PutMapping("/{receiptId}")
    public void update(@RequestBody Receipt receipt, @PathVariable Long receiptId) {
        receiptService.update(receipt, receiptId);
    }
    @GetMapping("/index")
    public String showIndex(Model model) {
        return "index";
    }

}
