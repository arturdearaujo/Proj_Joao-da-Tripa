package dev.artur.joaodatripa;

/**
 * Created by DEV02 on 27/07/2017.
 */

public class Item {

    /**The name of the product*/
    private int mName;

    /**The price of the product*/
    private int mUnitPrice;

    /**the quantity picked in the order*/
    private int quantity = 1;

    /**the total price of the desired number of this item*/
    private double mTotalPrice;

    /** Image resource ID for the item */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this item */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param name is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param price is the string resource Id for the word in the Miwok language
     */
    public Item(int name, int price){
        mName = name;
        mUnitPrice = price;
        mTotalPrice = quantity * mUnitPrice;
    }

    /**
     * Create a new Word object.
     *
     * @param name is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param price is the string resource Id for the word in the Miwok language
     */
    public Item(int name, int price, int imageResourceId){
        mName = name;
        mUnitPrice = price;
        mTotalPrice = quantity * mUnitPrice;
        mImageResourceId = imageResourceId;
    }

    public int getName() {
        return mName;
    }

    public double getUnitPrice() {
        return mUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }

    public double getmTotalPrice() {
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

}
