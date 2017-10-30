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

package dev.artur.joaodatripa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Item;

/**
 * This Activity shows the resume description about the item, like how many and for how much it was
 * last/best bought.(?) Artur, 05/10/2017.
 */
public class ItemSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_sumary);

        // Get the intent who created this activity.
        Intent itemIntent = getIntent();
        // Get the item putted inside the intent.
        Item item = (Item) itemIntent.getSerializableExtra("itemActivity");

        // Connect with the ImageView of the activity related xml layout file.
        ImageView itemImage = (ImageView) findViewById(R.id.item_image);
        // Check if an image is provided for this word or not
        if (item.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            itemImage.setImageResource(item.getImageResourceId());
            // Make sure the view is visible
            itemImage.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            itemImage.setVisibility(View.GONE);
        }

        TextView itemTitle = (TextView) findViewById(R.id.item_description_title);
        itemTitle.setText(item.getName());

        TextView itemPrice = (TextView) findViewById(R.id.item_price);
        itemPrice.setText(moneyFormat(item.getUnitPrice()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "R$ " + formatter.format(value);
    }
}
