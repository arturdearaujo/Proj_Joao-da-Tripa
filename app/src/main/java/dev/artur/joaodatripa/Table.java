package dev.artur.joaodatripa;

import java.util.ArrayList;

/**
 * Table class.
 * Created by artur on 05/08/2017.
 */

public class Table {

    /**
     * The number of the table for sorting.
     */
    private int number;

    private ArrayList<String> users;

    private ArrayList<Item> items;

    private double totalPrice;

    /**
     * Public constructor for a Table object.
     *
     * @param number the index of the tables in the saloon.
     */
    public Table(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getMainClientName(){
        return users.get(0);
    }

}
