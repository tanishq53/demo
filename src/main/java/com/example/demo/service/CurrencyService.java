package com.example.demo.service;

import com.example.demo.model.ConversionRecord;
import com.example.demo.repository.ConversionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private ConversionRecordRepository repository;

    public double convert(String from, String to, double amount) {
        // Step 1: Call the exchange rate API
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "68b099d4923cc47e11da50e3"; // Replace with your actual key
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + from;

        Map response = restTemplate.getForObject(url, Map.class);
        Map<String, Double> rates = (Map<String, Double>) response.get("conversion_rates");
        double rate = rates.get(to);

        // Step 2: Calculate result
        double result = amount * rate;

        // Step 3: Save to database
        ConversionRecord record = new ConversionRecord(from, to, amount, result);
        repository.save(record);

        return result;
    }
}