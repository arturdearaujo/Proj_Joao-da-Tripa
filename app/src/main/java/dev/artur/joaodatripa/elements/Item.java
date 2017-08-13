package dev.artur.joaodatripa.elements;

import android.content.Context;
import android.util.Log;

/**
 * Created by DEV02 on 27/07/2017.
 */

public class Item {

    /**
     * Constant value that represents no image was provided for this item
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    static String TAG = "Item class";
     private Context context;
    /**
     * The name of the product
     */
    private int mName;
    /**
     * The unit price of the item.
     */
    private double mUnitPrice;
    /**
     * The quantity picked in the order
     */
    private int quantity = 0;
    /**the total price of the desired number of this item*/
    private double mTotalPrice = mUnitPrice * quantity;
    /** Image resource ID for the item */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Basic Item constructor without image resource provided.
     *
     * @param nameResourceId is the string resource ID for the item name.
     * @param unitPriceResourceId is the price of the item.
     */
    public Item(Context context, int nameResourceId, int unitPriceResourceId, int imageResourceId) {
        this.mName = nameResourceId;
        this.mUnitPrice = Double.parseDouble(context.getString(unitPriceResourceId));
        this.mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Item object.
     *
     * @param nameResourceId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     */
    public Item(Context context, int nameResourceId, int unitPriceResourceId){
        this.mName = nameResourceId;
        this.mUnitPrice = Double.parseDouble(context.getString(unitPriceResourceId));
    }

    public int getName() {
        return mName;
    }

    public double getUnitPrice(){
        return mUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public double getTotalPrice() {
        mTotalPrice = mUnitPrice * quantity;
        return mTotalPrice;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean increment(){
        if (quantity >= 0 && quantity < 24) {
            quantity++;
            return true;
        } else {
            Log.e(TAG, "increment: out of bounds");
            return false;
        }
    }

    public boolean decrement(){
        if (quantity > 0 && quantity <= 24) {
            quantity--;
            return true;
        } else {
            Log.e(TAG, "increment: out of bounds");
            return false;
        }
    }

    public int updatePrice(){
        return getQuantity();
    }
}
