/*
 * Copyright (C) 2017 João da Tripa Bar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.artur.joaodatripa.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Item;

/**
 * Item Adapter class.
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
                    R.layout.list_item_item, parent, false);
        }
        // Get the {@link Item} object located at this position in the list
        final Item currentItem = getItem(position);

        //Use this method to set the correct color of the item.
        checkColor(currentItem, listItemView);


        // Find the TextView in the list_item_item.xml layout with the ID name_item_text_view.
        TextView nameItem = (TextView) listItemView.findViewById(R.id.name_item_text_view);
        nameItem.setText(currentItem.getName());

        // Find the TextView in the list_item_item.xml layout with the ID unit_price_text_view.
        TextView unitPriceItem = (TextView) listItemView.findViewById(R.id.unit_price_text_view);
        unitPriceItem.setText(moneyFormat(currentItem.getUnitPrice()));

        // Find the TextView in the list_item_item.xml layout with the ID total_price_text_view.
        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf("x" + currentItem.getQuantity()));

        double totalPrice = currentItem.getUnitPrice() * currentItem.getQuantity();
        // Find the TextView in the list_item_item_item.xml layout with the ID total_price_text_view.
        TextView totalPriceItem = (TextView) listItemView.findViewById(R.id.total_price_text_view);
        totalPriceItem.setText(moneyFormat(totalPrice));

        // Find the ImageView in the list_item_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }

    private boolean checkColor(Item currentItem, View listItemView) {
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.item_layout);
        // Find the color that the resource ID maps to
        int colorDefault = ContextCompat.getColor(getContext(), R.color.tan_background2);
        int colorAccent = ContextCompat.getColor(getContext(), R.color.colorAccent);

        // Set the background color of the text container View
        if (currentItem.getQuantity() != 0) {
            textContainer.setBackgroundColor(colorAccent);
            return true;
        } else {
            textContainer.setBackgroundColor(colorDefault);
            return false;
        }
    }

    private String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }
}