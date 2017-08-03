package dev.artur.joaodatripa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.artur.joaodatripa.Adapters.ItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderMenuFragment extends Fragment {

    private static final String TAG = "OrderMenuFragment";

    /**
     * The total price of items ordered by the user.
     */
    double totalOrder = 0;

    public OrderMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_order_menu, container, false);


        // Create a list of words
        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.item_1, R.string.item_price_1, R.drawable.antartica_600, 6.00));
        items.add(new Item(R.string.item_2, R.string.item_price_2, R.drawable.skol_600, 6.50));
        items.add(new Item(R.string.item_3, R.string.item_price_3, R.drawable.itaipava_600, 5.5));
        items.add(new Item(R.string.item_4, R.string.item_price_4, R.drawable.brahma_600, 5.50));
        items.add(new Item(R.string.item_5, R.string.item_price_5, R.drawable.skol_300, 3.00));
        items.add(new Item(R.string.item_6, R.string.item_price_6, R.drawable.itaipava_300, 3.00));
        items.add(new Item(R.string.item_7, R.string.item_price_7, R.drawable.skol_lata_350, 3.50));
        items.add(new Item(R.string.item_8, R.string.item_price_8, R.drawable.itaipava_lata_350, 3.00));
        items.add(new Item(R.string.item_9, R.string.item_price_9, R.drawable.vinho_sao_braz_200, 2.00));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getContext(), items, R.color.category_1);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to do the staff.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                final Item item = items.get(position);
                final View finalView = view;
                Button plusButton = (Button) view.findViewById(R.id.button_plus);
                Button minusButton = (Button) view.findViewById(R.id.button_minus);

                plusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean token = item.increment();

                        incrementTotalOrder(token, item.getDoubleUnitPrice());

                        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
                        totalOrderTextView.setText(String.valueOf(totalOrder));

                        TextView quantityTextView = (TextView) finalView.findViewById(R.id.quantity_text_view);
                        quantityTextView.setText(String.valueOf(item.updatePrice()));

                        TextView totalPriceItem = (TextView) finalView.findViewById(R.id.total_price_text_view);
                        totalPriceItem.setText(String.valueOf(item.getTotalPrice()));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean token = item.decrement();

                        decrementTotalOrder(token, item.getDoubleUnitPrice());

                        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
                        totalOrderTextView.setText(String.valueOf(totalOrder));

                        TextView quantityTextView = (TextView) finalView.findViewById(R.id.quantity_text_view);
                        quantityTextView.setText(String.valueOf(item.updatePrice()));

                        TextView totalPriceItem = (TextView) finalView.findViewById(R.id.total_price_text_view);
                        totalPriceItem.setText(String.valueOf(item.getTotalPrice()));
                    }
                });
            }
        });

        //Initializing and setting the total order price.
        TextView totalOrderTextView = (TextView) rootView.findViewById(R.id.total_order_text_view);
        totalOrderTextView.setText(String.valueOf(totalOrder));

        Button orderButton = (Button) rootView.findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
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
