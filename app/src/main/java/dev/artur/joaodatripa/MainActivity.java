package dev.artur.joaodatripa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of words
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.item_1, R.string.item_price_1));
        items.add(new Item(R.string.item_2, R.string.item_price_2));
        items.add(new Item(R.string.item_3, R.string.item_price_3));
        items.add(new Item(R.string.item_4, R.string.item_price_4));
        items.add(new Item(R.string.item_5, R.string.item_price_5));
        items.add(new Item(R.string.item_6, R.string.item_price_6));
        items.add(new Item(R.string.item_7, R.string.item_price_7));
        items.add(new Item(R.string.item_8, R.string.item_price_8));
        items.add(new Item(R.string.item_9, R.string.item_price_9));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(this, items, R.color.category_1);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Item word = items.get(position);


            }
        });
    }

}
