package dev.artur.joaodatripa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Order;
import dev.artur.joaodatripa.elements.Table;

public class TableActivity extends AppCompatActivity {

    TextView tableTittle;
    TextView tableSummary;
    TextView tableTotal;

    Table mTable;
    ArrayList<Order> mOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Intent tableIntent = getIntent();
        mTable = (Table) tableIntent.getSerializableExtra("table data");
//        Intent orderIntent = getIntent();

        tableTittle = (TextView) findViewById(R.id.table_title);
        tableTittle.setText(mTable.getTableTittle());

        tableSummary = (TextView) findViewById(R.id.table_summary);
        tableSummary.setText(mTable.getTableSummary());
//        tableSummary.setText("(exemplo)\n01\tÁgua de Coco\t\tR$3,00\n01\tMeota\t\tR$8,00");

        tableTotal = (TextView) findViewById(R.id.table_total);
        tableTotal.setText("R$ " + String.valueOf(mTable.getTotalPrice()));
//        tableTotal.setText("R$11,00");

//        Order order = (Order) orderIntent.getSerializableExtra("order");
//        mOrders.add(order);
    }
}