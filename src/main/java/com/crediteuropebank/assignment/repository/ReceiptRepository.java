package com.crediteuropebank.assignment.repository;

import com.crediteuropebank.assignment.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{

}
