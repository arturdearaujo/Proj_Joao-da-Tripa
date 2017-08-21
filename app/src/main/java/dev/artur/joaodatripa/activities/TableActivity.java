package dev.artur.joaodatripa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Order;
import dev.artur.joaodatripa.elements.Table;

public class TableActivity extends AppCompatActivity {

    Table mTable;
    ArrayList<Order> mOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Intent tableIntent = getIntent();
        Intent orderIntent = getIntent();
        mTable = (Table) tableIntent.getSerializableExtra("table data");
        Order order = (Order) orderIntent.getSerializableExtra("order");
//        mOrders.add(order);
    }
}
