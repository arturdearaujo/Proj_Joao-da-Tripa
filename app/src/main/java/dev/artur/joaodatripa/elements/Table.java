package dev.artur.joaodatripa.elements;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Table class.
 * Created by artur on 05/08/2017.
 */

public class Table implements Serializable {

    private final String AVAILABLE_TABLE = "Disponível";
    private final String RESERVED_TABLE = "Reservado";
    private final String OCCUPIED_TABLE = "Ocupado";
    public boolean tableSet = false;
    private int number;
    private String tableTittle;
    private String tableSummary;
    private double totalPrice;
    private ArrayList<Order> orders;
    /**
     * Public constructor for a Table object.
     *
     * @param number the index of the tables in the saloon.
     */
    public Table(int number) {
        this.number = number;
        tableTittle = "Mesa: " + String.valueOf(number);
        tableSummary = "";
    }

    public int getNumber() {
        return number;
    }

    public String getTableTittle() {
        return tableTittle;
    }

    public void setTableTittle(String tableTittle) {
        this.tableTittle = tableTittle;
    }

    public String getTableSummary() {
        return tableSummary;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void receiveOrder(Order order) {
        if (order.getTableNumber() == getNumber()) {
            this.tableSummary += order.getOrderNote();
        }
    }

    public void updateValues(Table newTable) {
        this.tableTittle = newTable.getTableTittle();
        this.tableSet = newTable.tableSet;
    }

    public void receivePayment(double value) {
        this.totalPrice = -value;
    }
}
