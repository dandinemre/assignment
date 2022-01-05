package com.crediteuropebank.assignment.repository;

import com.crediteuropebank.assignment.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

    void deleteByReceiptId(Long receiptId);

}
