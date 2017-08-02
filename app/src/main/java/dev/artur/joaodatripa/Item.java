package dev.artur.joaodatripa;

import android.util.Log;

/**
 * Created by DEV02 on 27/07/2017.
 */

public class Item {

    static String TAG = "Item class";

    /**The name of the product*/
    private int mName;

    /**The price of the product*/
    private int mUnitPrice;

    /**the quantity picked in the order*/
    private int quantity = 0;

    /**the total price of the desired number of this item*/
    private double mTotalPrice;

    /** Image resource ID for the item */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this item */
    private static final int NO_IMAGE_PROVIDED = -1;

    private double mUnitPrice2;


    /**
     * Create a new Item object.
     *
     * @param name is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param price is the string resource Id for the price of the item
     */
    public Item(int name, int price, int imageResourceId){
        mName = name;
        mUnitPrice = price;
        mTotalPrice = quantity * mUnitPrice;
        mImageResourceId = imageResourceId;
    }

    public Item(int name, int price, int imageResourceId, double unitPrice){
        mName = name;
        mUnitPrice = price;
        mTotalPrice = getTotalPrice();
        mImageResourceId = imageResourceId;
        mUnitPrice2 = unitPrice;
    }

    public int getName() {
        return mName;
    }

    public int getUnitPrice() {
        return mUnitPrice;
    }

    public double getDoubleUnitPrice(){
        return mUnitPrice2;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }

    public double getTotalPrice() {
        mTotalPrice = mUnitPrice2 * quantity;
        return mTotalPrice;
    }

    public void setmUnitPrice(int mUnitPrice) {
        this.mUnitPrice = mUnitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
