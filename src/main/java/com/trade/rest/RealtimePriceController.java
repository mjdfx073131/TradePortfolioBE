package com.trade.rest;

import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;

@RestController
@CrossOrigin()
@RequestMapping("/stock")
public class RealtimePriceController {

    @GetMapping("{ticker}")
    public Double getRealtimePrice(@PathVariable("ticker") String ticker) {
        try {
            Stock stock = YahooFinance.get(ticker);
            BigDecimal price = stock.getQuote().getPrice();
            double priceDouble = price.doubleValue();
            return priceDouble;
        } catch (Exception e) {
            return (double)0;
        }
    }
}