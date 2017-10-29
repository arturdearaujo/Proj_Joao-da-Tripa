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

    private ArrayList<Order> mOrdersList;

    private ArrayList<String> mItemsListNames;
    private ArrayList<Integer> mItemsListQuantities;
    private ArrayList<Double> mItemsListPrices;

    /**
     * Public constructor for a Table object.
     *
     * @param number the index of the tables in the saloon.
     */
    public Table(int number) {
        this.number = number;
        tableTittle = "Mesa: " + String.valueOf(number);
        tableSummary = "";

        mOrdersList = new ArrayList<>();

        mItemsListNames = new ArrayList<>();
        mItemsListQuantities = new ArrayList<>();
        mItemsListPrices = new ArrayList<>();
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

    // Aqui então será montada a String para exibir os itens da mesa..
    public String getTableSummary() {
        return createSummary();
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public void receiveOrder(Order order) {
        if (order.getTableNumber() == getNumber()) {
            for (int i = 0; i < order.getOrderSummaryName().size(); i++) {
                if (!mItemsListNames.contains(order.getOrderSummaryName().get(i))) {
                    mItemsListNames.add(order.getOrderSummaryName().get(i));
                    mItemsListQuantities.add(order.getmItemsListQuantities().get(i));
                    mItemsListPrices.add(order.getmItemsListPrices().get(i));
                } else {
                    int index = mItemsListNames.indexOf(order.getOrderSummaryName().get(i));
                    int aux = mItemsListQuantities.get(index) + order.getmItemsListQuantities().get(i);
                    mItemsListQuantities.set(index, aux);
                }
            }
        }
    }

    private String createSummary() {
        StringBuilder noteLine = new StringBuilder();
        int NAME_MIN_LENGTH = 15;
        for (int i = 0; i < mItemsListNames.size(); i++) {
            String name = mItemsListNames.get(i);
            double itemTotalPrice = mItemsListQuantities.get(i) * mItemsListPrices.get(i);
            noteLine.append("\n").append(mItemsListQuantities.get(i)).append("*\t").append(name.length() < NAME_MIN_LENGTH ? name : name.substring(0, NAME_MIN_LENGTH)).append("\t\tR$").append(mItemsListPrices.get(i)).append("\t\tR$").append(String.valueOf(itemTotalPrice));
        }
        return noteLine.toString();
    }

    public void updateValues(Table newTable) {
        this.tableTittle = newTable.getTableTittle();
        this.tableSet = newTable.tableSet;
    }

    public void receivePayment(double value) {
        this.totalPrice = -value;
    }
}
