package dev.artur.joaodatripa.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import dev.artur.joaodatripa.ItemBoard;
import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.activities.ItemSummaryActivity;
import dev.artur.joaodatripa.adapters.ItemAdapter;
import dev.artur.joaodatripa.elements.Item;
import dev.artur.joaodatripa.elements.Order;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private static final String TAG = "ItemsFragment";

    /**
     * The total price of items ordered by the user.
     */
    double totalOrder = 0;

    ItemBoard myNoteBoard;

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        // Creates the board to annotate the orders.
        myNoteBoard = new ItemBoard(new ArrayList<String>());

        // Create a list of words
        final ArrayList<Item> items = new ArrayList<>();

//        items.add(new Item(getContext(),R.string.item_0, R.string.item_price_0));
        items.add(new Item(getContext(), R.string.item_1, R.string.item_price_1, R.drawable.antartica_600));
        items.add(new Item(getContext(), R.string.item_2, R.string.item_price_2, R.drawable.skol_600));
        items.add(new Item(getContext(), R.string.item_3, R.string.item_price_3, R.drawable.itaipava_600));
        items.add(new Item(getContext(), R.string.item_4, R.string.item_price_4, R.drawable.brahma_600));
        items.add(new Item(getContext(), R.string.item_5, R.string.item_price_5, R.drawable.skol_300));
        items.add(new Item(getContext(), R.string.item_6, R.string.item_price_6, R.drawable.itaipava_300));
        items.add(new Item(getContext(), R.string.item_7, R.string.item_price_7, R.drawable.skol_lata_350));
        items.add(new Item(getContext(), R.string.item_8, R.string.item_price_8, R.drawable.itaipava_lata_350));
        items.add(new Item(getContext(), R.string.item_9, R.string.item_price_9, R.drawable.vinho_sao_braz_200));

//        items.add(new Item(getContext(),R.string.item_10, R.string.item_price_10));
        items.add(new Item(getContext(), R.string.item_11, R.string.item_price_11));
        items.add(new Item(getContext(), R.string.item_12, R.string.item_price_12));
        items.add(new Item(getContext(), R.string.item_13, R.string.item_price_13));
        items.add(new Item(getContext(), R.string.item_14, R.string.item_price_14));
        items.add(new Item(getContext(), R.string.item_15, R.string.item_price_15));
        items.add(new Item(getContext(), R.string.item_16, R.string.item_price_16));
        items.add(new Item(getContext(), R.string.item_17, R.string.item_price_17));
        items.add(new Item(getContext(), R.string.item_18, R.string.item_price_18));
        items.add(new Item(getContext(), R.string.item_19, R.string.item_price_19));
        items.add(new Item(getContext(), R.string.item_20, R.string.item_price_20));
        items.add(new Item(getContext(), R.string.item_21, R.string.item_price_21));
        items.add(new Item(getContext(), R.string.item_22, R.string.item_price_22));
        items.add(new Item(getContext(), R.string.item_23, R.string.item_price_23));
        items.add(new Item(getContext(), R.string.item_24, R.string.item_price_24));

//        items.add(new Item(getContext(),R.string.item_25, R.string.item_price_25));
        items.add(new Item(getContext(), R.string.item_26, R.string.item_price_26));
        items.add(new Item(getContext(), R.string.item_27, R.string.item_price_27));
        items.add(new Item(getContext(), R.string.item_28, R.string.item_price_28));
        items.add(new Item(getContext(), R.string.item_29, R.string.item_price_29));
        items.add(new Item(getContext(), R.string.item_30, R.string.item_price_30));
        items.add(new Item(getContext(), R.string.item_31, R.string.item_price_31));
        items.add(new Item(getContext(), R.string.item_32, R.string.item_price_32));
        items.add(new Item(getContext(), R.string.item_33, R.string.item_price_33));
        items.add(new Item(getContext(), R.string.item_34, R.string.item_price_34));
        items.add(new Item(getContext(), R.string.item_35, R.string.item_price_35));
        items.add(new Item(getContext(), R.string.item_36, R.string.item_price_36));
        items.add(new Item(getContext(), R.string.item_37, R.string.item_price_37));

//        items.add(new Item(getContext(),R.string.item_38, R.string.item_price_38));
        items.add(new Item(getContext(), R.string.item_39, R.string.item_price_39));
        items.add(new Item(getContext(), R.string.item_40, R.string.item_price_40));
        items.add(new Item(getContext(), R.string.item_41, R.string.item_price_41));
        items.add(new Item(getContext(), R.string.item_42, R.string.item_price_42));
        items.add(new Item(getContext(), R.string.item_43, R.string.item_price_43));
        items.add(new Item(getContext(), R.string.item_44, R.string.item_price_44));
        items.add(new Item(getContext(), R.string.item_45, R.string.item_price_45));
        items.add(new Item(getContext(), R.string.item_46, R.string.item_price_46));
        items.add(new Item(getContext(), R.string.item_47, R.string.item_price_47));
        items.add(new Item(getContext(), R.string.item_48, R.string.item_price_48));
        items.add(new Item(getContext(), R.string.item_49, R.string.item_price_49));
        items.add(new Item(getContext(), R.string.item_50, R.string.item_price_50));
        items.add(new Item(getContext(), R.string.item_51, R.string.item_price_51));
        items.add(new Item(getContext(), R.string.item_52, R.string.item_price_52));

//        items.add(new Item(getContext(),R.string.item_53, R.string.item_price_53));
        items.add(new Item(getContext(), R.string.item_54, R.string.item_price_54));
        items.add(new Item(getContext(), R.string.item_55, R.string.item_price_55));
        items.add(new Item(getContext(), R.string.item_56, R.string.item_price_56));
        items.add(new Item(getContext(), R.string.item_57, R.string.item_price_57));
        items.add(new Item(getContext(), R.string.item_58, R.string.item_price_58));
        items.add(new Item(getContext(), R.string.item_59, R.string.item_price_59));
        items.add(new Item(getContext(), R.string.item_60, R.string.item_price_60));
        items.add(new Item(getContext(), R.string.item_61, R.string.item_price_61));
        items.add(new Item(getContext(), R.string.item_62, R.string.item_price_62));
        items.add(new Item(getContext(), R.string.item_63, R.string.item_price_63));
        items.add(new Item(getContext(), R.string.item_64, R.string.item_price_64));
        items.add(new Item(getContext(), R.string.item_65, R.string.item_price_65));
        items.add(new Item(getContext(), R.string.item_66, R.string.item_price_66));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getContext(), items, R.color.tan_background);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list_of_items);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to do the staff.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                final Item item = items.get(position);
                Button plusButton = (Button) view.findViewById(R.id.button_plus);
                Button minusButton = (Button) view.findViewById(R.id.button_minus);

                Log.d(TAG, "onItemClick: cliquei no item :)");
                // This methods switch the color of the itemView based on the quantity of the item.
                toggleColor(view, item);

                plusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean token = item.increment();

                        incrementTotalOrder(token, item.getUnitPrice());

                        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
                        totalOrderTextView.setText(moneyFormat(totalOrder));

                        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity_text_view);
                        quantityTextView.setText(String.valueOf("x" + item.getQuantity()));

                        double totalPrice = item.getUnitPrice() * item.getQuantity();
                        TextView totalPriceItem = (TextView) view.findViewById(R.id.total_price_text_view);
                        totalPriceItem.setText(moneyFormat(totalPrice));

                        toggleColor(view, item);

                        //Inserir aqui uma função que descreve a ação realizada(no caso, adiciona um pedido, em texto)
                        String note = myNoteBoard.takeNote(item.getName(), item.getQuantity(), item.getUnitPrice(), totalOrder, token);
                        TextView summaryTextView = (TextView) getActivity().findViewById(R.id.order_summary_text_view);
                        summaryTextView.setText(note);
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean token = item.decrement();

                        decrementTotalOrder(token, item.getUnitPrice());

                        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
                        totalOrderTextView.setText(moneyFormat(totalOrder));

                        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity_text_view);
                        quantityTextView.setText(String.valueOf("x" + item.getQuantity()));

                        double totalPrice = item.getUnitPrice() * item.getQuantity();
                        TextView totalPriceItem = (TextView) view.findViewById(R.id.total_price_text_view);
                        totalPriceItem.setText(moneyFormat(totalPrice));

                        toggleColor(view, item);

                        //Inserir aqui uma função que descreve a ação realizada(no caso, adiciona um pedido, em texto)
                        String note = myNoteBoard.takeNote(item.getName(), item.getQuantity(), item.getUnitPrice(), totalOrder, token);
                        TextView summaryTextView = (TextView) getActivity().findViewById(R.id.order_summary_text_view);
                        summaryTextView.setText(note);
                    }
                });
            }

            private void toggleColor(View view, Item item) {
                if (item.getQuantity() != 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        view.setBackgroundColor(getResources().getColor(R.color.colorAccent, getActivity().getTheme()));
                    } else {
                        view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        view.setBackgroundColor(getResources().getColor(R.color.tan_background2, getActivity().getTheme()));
                    } else {
                        view.setBackgroundColor(getResources().getColor(R.color.tan_background2));
                    }
                }
            }

        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Item item = items.get(position);
                Intent itemSummaryActivity = new Intent(parent.getContext(), ItemSummaryActivity.class);
                itemSummaryActivity.putExtra("itemActivity", item);
                startActivity(itemSummaryActivity);
                return false;
            }

        });

        //Initializing and setting the total order price.
        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
        totalOrderTextView.setMovementMethod(new ScrollingMovementMethod());
        totalOrderTextView.setText(moneyFormat(totalOrder));

        Button orderButton = (Button) rootView.findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (totalOrder > 0) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                    View mView = getLayoutInflater(savedInstanceState).inflate(R.layout.dialog_order_summary, null);
                    final AlertDialog dialog;

                    mBuilder.setView(mView);
                    dialog = mBuilder.create();

                    Button confirmOrder = (Button) mView.findViewById(R.id.btn_confirm_order);
//                    confirmOrder.setEnabled(false);

                    TextView mOrderSummary = (TextView) mView.findViewById(R.id.orderSummary);
                    final Spinner tableSpinner = (Spinner) mView.findViewById(R.id.spinner_tables);
                    EditText obsEditText = (EditText) mView.findViewById(R.id.et_observation_notes);

                    mOrderSummary.setText(myNoteBoard.makeText());
                    mOrderSummary.setMovementMethod(new ScrollingMovementMethod());

                    final String[] tablesArray = {"Escolha uma mesa:",
                            "Mesa 0",
                            "Mesa 1",
                            "Mesa 2",
                            "Mesa 3",
                            "Mesa 4",
                            "Mesa 5",
                            "Mesa 6",
                            "Mesa 7",
                            "Mesa 8",
                            "Mesa 9"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, tablesArray);
                    tableSpinner.setAdapter(adapter);

                    final int[] table = {-1};
                    tableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position != 0) table[0] = position;
                            else table[0] = -1;
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Toast.makeText(getContext(), "ah-haaa onNothingSelected.", Toast.LENGTH_SHORT).show();
                        }
                    });


                    final String observationMsgs = obsEditText.getText().toString();


                    confirmOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (table[0] != -1) {
                                Order newOrder = new Order(myNoteBoard.makeText(), table[0], observationMsgs);

                                // A questão em criar uma nova activity a partir daqui é que a mesa pode já existir.
                                // Como alternativa, envia por intent contendo a newOrder, e o numero da mesa q deverá recebe-lo.*/
                                Intent newOrderIntent = new Intent("order");
                                newOrderIntent.putExtra("mesa " + String.valueOf(newOrder.getTableNumber()), newOrder);

                                // Finalizar o dialogOrderSummary.
                                // A melhor opção realmente é o método cancel() ?
                                dialog.cancel();

                                Toast.makeText(getContext(), "Pedido realizado para a mesa: " + +table[0], Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    // Show the dialog.
                    dialog.show();
                }
            }
        });

        return rootView;
    }

    public String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }

    private void decrementTotalOrder(boolean token, double value) {
        if (token) {
            totalOrder = totalOrder - value;
        }
    }

    public void incrementTotalOrder(boolean token, double value) {
        if (token) {
            totalOrder = totalOrder + value;
        }
    }

}
