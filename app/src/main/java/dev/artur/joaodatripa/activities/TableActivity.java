package dev.artur.joaodatripa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        final Button receivePaymentButton = dialogPaymentView.findViewById(R.id.button_payment);
        final LinearLayout[] receivedValueField = new LinearLayout[1];
        final TextView[] receivedTextView = new TextView[1];
        final LinearLayout[] changeField = new LinearLayout[1];
        final TextView[] changeTextView = new TextView[1];

        final TextView[] adviseTextView = new TextView[1];
        adviseTextView[0] = dialogPaymentView.findViewById(R.id.partial_payment_advise_text_view);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTable.getTotalPrice() > 0) {
                    paymentDialog.show();

                    receivePaymentButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            value[0] = Double.valueOf(paymentValueEditText.getText().toString());

                            int aux = Double.compare(value[0], mTable.getTotalPrice());
//                            double change = mTable.receivePayment(value[0]);

                            receivedValueField[0] = findViewById(R.id.payed_value_LinearLayout);
                            receivedTextView[0] = findViewById(R.id.payed_value_TextView);
                            changeField[0] = findViewById(R.id.exchange_LinearLayout);
                            changeTextView[0] = findViewById(R.id.exchange_TextView);

                            // se igual, o troco é 0. exibir ok, e limpar a mesa;
                            if ((aux == 0)) {
                                receivedValueField[0].setVisibility(View.VISIBLE);
                                changeField[0].setVisibility(View.VISIBLE);

                                receivedTextView[0].setText(moneyFormat(value[0]));
                                changeTextView[0].setText(moneyFormat(0));

                                Toast.makeText(TableActivity.this, "A conta foi paga com sucesso! :)", Toast.LENGTH_SHORT).show();

                                paymentDialog.cancel();

                                mTable.confirmPayment();
                                // falta enviar a mesa para a lista de mesas da main activity.


                                // se pago foi maior, exibe o troco e limpa a mesa
                            } else if (aux > 0) {
                                receivedValueField[0].setVisibility(View.VISIBLE);
                                changeField[0].setVisibility(View.VISIBLE);

                                receivedTextView[0].setText(moneyFormat(value[0]));
                                changeTextView[0].setText(moneyFormat(value[0] - mTable.getTotalPrice()));

                                Toast.makeText(TableActivity.this, "A conta foi paga, confira o troco :)", Toast.LENGTH_SHORT).show();
                                paymentDialog.cancel();

                                mTable.confirmPayment();
                                // se o valor pago não foi suficiente, tratar com mais atenção...
                            } else {
                                final TextView adviseTextView = dialogPaymentView.findViewById(R.id.partial_payment_advise_text_view);
                                final Button cancelPaymentButton = dialogPaymentView.findViewById(R.id.button_cancel_payment);
                                final Button confirmPaymentButton = dialogPaymentView.findViewById(R.id.confirm_payment_button);

                                adviseTextView.setVisibility(View.VISIBLE);
                                cancelPaymentButton.setVisibility(View.VISIBLE);
                                confirmPaymentButton.setVisibility(View.VISIBLE);

                                receivePaymentButton.setVisibility(View.GONE);
                                paymentValueEditText.setEnabled(false);

                                cancelPaymentButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        adviseTextView.setVisibility(View.GONE);
                                        cancelPaymentButton.setVisibility(View.GONE);
                                        confirmPaymentButton.setVisibility(View.GONE);
                                        receivePaymentButton.setVisibility(View.VISIBLE);
                                        paymentValueEditText.setEnabled(true);
                                        paymentValueEditText.clearComposingText();

                                        paymentDialog.cancel();
                                    }
                                });

                                confirmPaymentButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mTable.confirmPayment();
                                        paymentDialog.cancel();
                                        Toast.makeText(getApplicationContext(), "o valor pago foi deduzido da conta (ainda n funciona..)", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            Intent tableResultIntent = new Intent();
                            tableResultIntent.putExtra("tableUpdate", mTable);
                            setResult(RESULT_OK, tableResultIntent);
                        }
                    });

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

    @Override
    protected void onStop() {
        super.onStop();
        Intent tableResultIntent = new Intent();
        tableResultIntent.putExtra("tableUpdate", mTable);
        setResult(RESULT_OK, tableResultIntent);
    }

    public String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }
}