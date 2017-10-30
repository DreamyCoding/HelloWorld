package com.dreamycoding.helloworld;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuyelRana on 10/30/2017.
 */

public class StockDataAdapter extends RecyclerView.Adapter<StockUpdateViewHolder> {

    private final List<StockUpdate> data = new ArrayList<>();

    @Override
    public StockUpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_update_item, parent, false);
        StockUpdateViewHolder holder = new StockUpdateViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StockUpdateViewHolder holder, int position) {
        /*StockUpdate	stockUpdate	=	data.get(position);
        holder.setStockSymbol(stockUpdate.getStockSymbol());
        holder.setPrice(stockUpdate.getPrice());
        holder.setDate(stockUpdate.getDate());*/
        StockUpdate stockUpdate = data.get(position);
        holder.setStockSymbol(stockUpdate.getStockSymbol());
        holder.setPrice(stockUpdate.getPrice());
        holder.setDate(stockUpdate.getDate());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(StockUpdate stockUpdate) {
        this.data.add(stockUpdate);
        notifyItemInserted(data.size() - 1);
    }
}
