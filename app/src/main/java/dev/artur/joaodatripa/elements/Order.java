package dev.artur.joaodatripa.elements;

import java.io.Serializable;

/**
 * Created by artur on 20/08/2017.
 */

public class Order implements Serializable {

    private int tableNumber;
    private String orderNote;
    private String obsMsg;

    public Order(String orderNote, int tableNumber, String obsMsg) {
        this.orderNote = orderNote;
        this.tableNumber = tableNumber;
        this.obsMsg = obsMsg;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getOrderNote() {
        return orderNote;
    }
}
