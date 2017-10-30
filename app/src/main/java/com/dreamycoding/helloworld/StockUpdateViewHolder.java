package com.dreamycoding.helloworld;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JuyelRana on 10/30/2017.
 */

public class StockUpdateViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.stock_item_symbol)
    TextView stockSymbol;
    @BindView(R.id.stock_item_date)
    TextView date;
    @BindView(R.id.stock_item_price)
    TextView price;
    private static final NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

    public StockUpdateViewHolder(View itemView) {
        super(itemView);
        stockSymbol = (TextView) itemView.findViewById(R.id.stock_item_symbol);
        date = (TextView) itemView.findViewById(R.id.stock_item_date);
        price = (TextView) itemView.findViewById(R.id.stock_item_price);
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol.setText(stockSymbol);
    }

    public void setPrice(BigDecimal price) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.price.setText(PRICE_FORMAT.format(price.floatValue()));
        }
    }

    public void setDate(Date date) {
        this.date.setText(DateFormat.format("yyyy-MM-dd	hh:mm", date));
    }
}