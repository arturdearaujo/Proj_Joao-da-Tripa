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

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Table;

import static java.lang.Double.valueOf;

public class TableActivity extends AppCompatActivity {

    TextView tableTittle;
    TextView tableSummary;
    TextView tableTotal;
    Button paymentButton;

    Table mTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Intent tableIntent = getIntent();
        mTable = (Table) tableIntent.getSerializableExtra("table data");

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        final AlertDialog tableTittleDialog;

        if (!mTable.tableSet) {
            View dialogTableTittleView = getLayoutInflater().inflate(R.layout.dialog_table_tittle, null);

            mBuilder.setView(dialogTableTittleView);
            tableTittleDialog = mBuilder.create();

            Button confirmTableTittleButton = dialogTableTittleView.findViewById(R.id.button_register_table_tittle);
            final EditText tableTitleEditText = dialogTableTittleView.findViewById(R.id.et_client_name);

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

                        tableTittleDialog.cancel();
                    } else {
                        Toast.makeText(TableActivity.this, "Escreva algo para ajudar a lembrar do cliente..", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Show the dialog.
            tableTittleDialog.show();
        }

        paymentButton = (Button) findViewById(R.id.button_activity_payment);

        final View dialogPaymentView = getLayoutInflater().inflate(R.layout.dialog_payment, null);
        final AlertDialog paymentDialog;
        mBuilder.setView(dialogPaymentView);
        paymentDialog = mBuilder.create();
        final double[] value = new double[1];
        final EditText paymentValueEditText = dialogPaymentView.findViewById(R.id.edit_text_payment_value);
        final Button receivePayment = dialogPaymentView.findViewById(R.id.button_payment);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CONTINUAR AQUI.. (pista: fazer o totalPrice funcionar)
                if (mTable.getTotalPrice() > 0) {


                    receivePayment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            value[0] = Double.valueOf(paymentValueEditText.getText().toString());

                            if (value[0] >= 0) {
                                mTable.receivePayment(value[0]);

                                Intent tableResultIntent = new Intent();
                                tableResultIntent.putExtra("tableUpdate", mTable);
                                setResult(RESULT_OK, tableResultIntent);

                                tableTotal.setText(moneyFormat(valueOf(mTable.getTotalPrice())));

                                paymentDialog.cancel();
                            }
                        }
                    });
                    paymentDialog.show();
                } else {
                    Toast.makeText(TableActivity.this, "A conta já está paga.", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    public String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }
}