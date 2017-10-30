package com.dreamycoding.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textHello)
    TextView textView;
    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private StockDataAdapter stockDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textHello);

        ButterKnife.bind(this);

        Observable.just("Hello ! Please use this app!")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        textView.setText(s);
                    }
                });

        recyclerView = (RecyclerView) findViewById(R.id.stock_updates_recycler_view);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        stockDataAdapter = new StockDataAdapter();

        recyclerView.setAdapter(stockDataAdapter);

        /*Observable.just(
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date()),
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date()),
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date())
        ).subscribe(new Consumer<StockUpdate>() {
            @Override
            public void accept(StockUpdate stockUpdate) throws Exception {
                stockDataAdapter.add(stockUpdate);
            }
        });*/

        Observable.just(
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date()),
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date()),
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date()))

                .doOnNext(e -> Log.d("APP", "on-next:" + Thread.currentThread().getName() + ":" + e.getStockSymbol()))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.i("Complete : ", "Complete Syncing");
                    }
                })
                .subscribe(stockUpdate -> {
                    Log.d("APP", "New	update	" + stockUpdate.getStockSymbol());
                    stockDataAdapter.add(stockUpdate);
                });

    }
}
