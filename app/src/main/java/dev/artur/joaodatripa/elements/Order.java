package dev.artur.joaodatripa.elements;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by artur on 20/08/2017.
 */

public class Order implements Serializable {

    private int tableNumber;
    private String orderResume;
    private String obsMsg;

    private ArrayList<String> mItemsListNames;
    private ArrayList<Integer> mItemsListQuantities;
    private ArrayList<Double> mItemsListPrices;

    public Order(int tableNumber, String obsMsg, ArrayList<String> orderSummaryName, ArrayList<Integer> mItemsListQuantities, ArrayList<Double> mItemsListPrices) {
        this.tableNumber = tableNumber;
        this.obsMsg = obsMsg;
        this.mItemsListNames = orderSummaryName;
        this.mItemsListQuantities = mItemsListQuantities;
        this.mItemsListPrices = mItemsListPrices;
        this.orderResume = createOrderResume();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getOrderResume() {
        return orderResume;
    }

    public String getObsMsg() {
        return obsMsg;
    }

    public ArrayList<String> getOrderSummaryName() {
        return mItemsListNames;
    }

    public ArrayList<Integer> getmItemsListQuantities() {
        return mItemsListQuantities;
    }

    public ArrayList<Double> getmItemsListPrices() {
        return mItemsListPrices;
    }


    private String createOrderResume() {
        // Lembrar que aqui defino um tamanho máximo para o texto do item, evitando itens de nome menor que o tamanho minimo.
        int NAME_MIN_LENGTH = 15;
        String noteLine = "Resumo do pedido:";
        for (int i = 0; i < mItemsListNames.size(); i++) {
            String name = mItemsListNames.get(i);
            double itemTotalPrice = mItemsListQuantities.get(i) * mItemsListPrices.get(i);
            noteLine += ("\n" + mItemsListQuantities.get(i) + "*\t" + (name.length() < NAME_MIN_LENGTH ? name : name.substring(0, NAME_MIN_LENGTH)) + "\t\tR$" + mItemsListPrices.get(i) + "\t\tR$" + String.valueOf(itemTotalPrice));
        }

        return noteLine;
    }

    public String getOrderNote() {
        return createOrderResume();
    }
}
