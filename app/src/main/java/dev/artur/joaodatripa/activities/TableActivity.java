package dev.artur.joaodatripa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Order;
import dev.artur.joaodatripa.elements.Table;

import static java.lang.Double.valueOf;

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

        if (!mTable.tableSet) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_table_tittle, null);
            final AlertDialog dialog;

            mBuilder.setView(mView);
            dialog = mBuilder.create();

            Button confirmTableTittleButton = mView.findViewById(R.id.button_register_table_tittle);
            final EditText tableTitleEditText = mView.findViewById(R.id.et_client_name);

            confirmTableTittleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String clientName = tableTitleEditText.getText().toString();
                    if (clientName.length() != 0) {

                        mTable.setTableTittle(clientName);

                        tableTittle = (TextView) findViewById(R.id.table_title);
                        tableTittle.setText(mTable.getTableTittle());

                        mTable.tableSet = true;

                        Intent tableResultIntent = new Intent();
                        tableResultIntent.putExtra("tableUpdate", mTable);
                        setResult(RESULT_FIRST_USER, tableResultIntent);

                        dialog.cancel();
                    } else {
                        Toast.makeText(TableActivity.this, "Escreva algo para ajudar a lembrar do cliente..", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            // Show the dialog.
            dialog.show();


        }
//        Intent orderIntent = getIntent();

//        Order order = (Order) orderIntent.getSerializableExtra("order");
//        mOrders.add(order);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tableTittle = (TextView) findViewById(R.id.table_title);
        tableTittle.setText(mTable.getTableTittle());

        tableSummary = (TextView) findViewById(R.id.table_summary);
        tableSummary.setText(mTable.getTableSummary());
//        tableSummary.setText("(exemplo)\n01\tÁgua de Coco\t\tR$3,00\n01\tMeota\t\tR$8,00");

        tableTotal = (TextView) findViewById(R.id.table_total);
        tableTotal.setText(moneyFormat(valueOf(mTable.getTotalPrice())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity destroyed", Toast.LENGTH_SHORT).show();

    }

    public String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }
}