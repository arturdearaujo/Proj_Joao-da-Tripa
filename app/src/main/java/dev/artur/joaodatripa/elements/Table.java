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

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

    // Aqui então será montada a String para exibir os itens da mesa..
    public String getTableLinePrices() {
        return createLinePrices();
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
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        totalPrice = 0;
        for (int i = 0; i < mItemsListPrices.size(); i++) {
            if (mItemsListQuantities.get(i) != 0) {
                totalPrice += (mItemsListPrices.get(i) * mItemsListQuantities.get(i));
            } else {
                totalPrice += (mItemsListPrices.get(i));
            }
        }
    }

    private String createSummary() {
        StringBuilder noteLine = new StringBuilder();
        int NAME_MIN_LENGTH = 20;
        for (int i = 0; i < mItemsListNames.size(); i++) {
            String name = mItemsListNames.get(i);
            if (mItemsListQuantities.get(i) != 0) {
                noteLine.append("\n").append(mItemsListQuantities.get(i)).append("*\t").append(name.length() < NAME_MIN_LENGTH ? name : name.substring(0, NAME_MIN_LENGTH)).append("\t\tR$").append(mItemsListPrices.get(i));
            } else {
                noteLine.append("\n\n").append(name).append("\n");

            }
        }
        return noteLine.toString();
    }

    private String createLinePrices() {
        StringBuilder noteLine = new StringBuilder();
        for (int i = 0; i < mItemsListNames.size(); i++) {
            String name = mItemsListNames.get(i);
            if (mItemsListQuantities.get(i) != 0) {
                double itemTotalPrice = mItemsListQuantities.get(i) * mItemsListPrices.get(i);
                noteLine.append(moneyFormat(itemTotalPrice));
            } else {
                noteLine.append("\n---");

            }
        }
        return noteLine.toString();
    }

    public void updateValues(Table newTable) {
        this.tableTittle = newTable.getTableTittle();
        this.tableSet = newTable.tableSet;
    }

    public String createAmend(double value) {
        this.totalPrice = (totalPrice - value);
        StringBuilder amendment = new StringBuilder();

        String currentTime = Calendar.getInstance().getTime().toString();

        amendment.append("Pagamento parcial de R$ ").append(String.valueOf(value)).append(" em: ").append(currentTime);

        mItemsListQuantities.add(0);
        mItemsListNames.add(amendment.toString());
        mItemsListPrices.add((-1) * value);

        String sumary = createSummary();
        updateTotalPrice();

        return amendment.toString();
    }

    // a ideia é chamar essa função somente quando a mesa ja tiver finalizado a conta. Não confundir com receivePayment()
    public void confirmPayment() {
        clearTable();
        this.totalPrice = 0;
    }

    private void clearTable() {
        mItemsListNames.clear();
        mItemsListQuantities.clear();
        mItemsListPrices.clear();
        this.totalPrice = 0;
    }

    private String moneyFormat(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "\nR$ " + formatter.format(value);
    }
}
