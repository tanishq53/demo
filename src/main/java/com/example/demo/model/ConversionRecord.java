package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConversionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double result;
    private LocalDateTime timestamp;

    // Constructors
    public ConversionRecord() {}

    public ConversionRecord(String fromCurrency, String toCurrency, double amount, double result) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    // (You can use Lombok later to simplify this)
}