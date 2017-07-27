package dev.artur.joaodatripa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEV02 on 27/07/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param items is the list of {@link Item}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Item currentItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_item_text_view.
        TextView nameItem = (TextView) listItemView.findViewById(R.id.name_item_text_view);
        nameItem.setText(currentItem.getName());

        // Find the TextView in the list_item.xml layout with the ID unit_price_text_view.
        TextView unitPriceItem = (TextView) listItemView.findViewById(R.id.unit_price_text_view);
        unitPriceItem.setText(String.valueOf(currentItem.getUnitPrice()));

        // Find the TextView in the list_item.xml layout with the ID total_price_text_view.
        TextView totalPriceItem = (TextView) listItemView.findViewById(R.id.total_price_text_view);
        totalPriceItem.setText(String.valueOf(currentItem.getUnitPrice()));


        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }

}
