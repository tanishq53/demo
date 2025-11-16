package com.example.demo.repository;

import com.example.demo.model.ConversionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRecordRepository extends JpaRepository<ConversionRecord, Long> {
    // You can add custom queries later if needed
}