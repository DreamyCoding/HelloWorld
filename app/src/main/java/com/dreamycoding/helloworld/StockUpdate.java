package com.dreamycoding.helloworld;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by JuyelRana on 10/30/2017.
 */

public class StockUpdate implements Serializable {
    private final String stockSymbol;
    private final BigDecimal price;
    private final Date date;

    public StockUpdate(String stockSymbol, double price, Date date) {
        this.stockSymbol = stockSymbol;
        this.price = new BigDecimal(price);
        this.date = date;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
