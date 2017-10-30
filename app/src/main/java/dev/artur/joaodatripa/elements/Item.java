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
package dev.artur.joaodatripa.elements;

import android.content.Context;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by DEV02 on 27/07/2017.
 */

public class Item implements Serializable {

    private static final int NO_IMAGE_PROVIDED = -1;
    private static String TAG = "Item class";
    private int mNameId;
    private int quantity = 0;
    private double mUnitPrice;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private String mStringName;


    /**
     * Item constructor with full resources.
     *
     * @param context
     * @param nameResourceId
     * @param unitPriceResourceId
     * @param imageResourceId
     */
    public Item(Context context, int nameResourceId, int unitPriceResourceId, int imageResourceId) {
        this.mStringName = context.getString(nameResourceId);
        this.mNameId = nameResourceId;
        this.mUnitPrice = Double.parseDouble(context.getString(unitPriceResourceId));
        this.mImageResourceId = imageResourceId;
    }

    /**
     * Basic Item constructor without image resource provided.
     *
     * @param context                Only used inside the constructor to obtain the String from the resourceId provided.
     * @param nameResourceId
     * @param unitPriceResourceId
     */
    public Item(Context context, int nameResourceId, int unitPriceResourceId) {
        this.mStringName = context.getString(nameResourceId);
        this.mNameId = nameResourceId;
        this.mUnitPrice = Double.parseDouble(context.getString(unitPriceResourceId));
    }


    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }


    public String getName() {
        return mStringName;
    }

    public double getUnitPrice() {
        return mUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }


    public boolean increment() {
        if (quantity >= 0 && quantity < 24) {
            quantity++;
            return true;
        } else {
            Log.e(TAG, "pedidos demais!!!");
            return false;
        }
    }

    public boolean decrement() {
        if (quantity > 0 && quantity <= 24) {
            quantity--;
            return true;
        } else {
            Log.e(TAG, "increment: out of bounds");
            return false;
        }
    }

}
