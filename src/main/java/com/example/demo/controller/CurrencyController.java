package com.example.demo.controller;

import com.example.demo.model.ConversionRecord;
import com.example.demo.repository.ConversionRecordRepository;
import com.example.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private ConversionRecordRepository repository;

    @GetMapping("/convert")
    public String convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount
    ) {
        double result = currencyService.convert(from, to, amount);
        return "Converted " + amount + " from " + from + " to " + to + " result: " + result;
    }

    @GetMapping("/history")
    public List<ConversionRecord> getHistory() {
        return repository.findAll();
    }
}