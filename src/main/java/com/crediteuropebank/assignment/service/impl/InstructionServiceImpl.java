package com.crediteuropebank.assignment.service.impl;

import com.crediteuropebank.assignment.repository.InstructionRepository;
import com.crediteuropebank.assignment.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionServiceImpl implements InstructionService {

    @Autowired
    InstructionRepository instructionRepository;

    @Override
    public void delete(Long instructionId) {
        instructionRepository.deleteById(instructionId);
    }

    @Override
    public void deleteByReceiptId(Long receiptId) {
        instructionRepository.deleteByReceiptId(receiptId);
    }


}
