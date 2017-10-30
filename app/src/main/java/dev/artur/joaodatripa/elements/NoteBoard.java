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

import java.util.ArrayList;

/**
 * NoteBoard class. ["caderneta de pedidos"]
 * <p>
 * Classe criada com a finalidade de abstrair uma caderneta onde se anotam todos os pedidos
 * a serem realizados pelo cliente. O objetivo principal seria implementar uma lógica que
 * entregue a um TextView a lista de pedidos realizados do cardápio.
 * <p>
 * Created by artur on 16/08/2017.
 */

public class NoteBoard {

    // Uso esta variável para preencher com as noteLines (String).
    private ArrayList<String> orderSummaryItem;

    // Uso esta para comparar o nome dos produtos se já existem no pedido.
    private ArrayList<String> orderSummaryName;
    private ArrayList<Integer> orderSummaryQuantity;
    private ArrayList<Double> orderSummaryPrice;

    public NoteBoard(ArrayList<String> orderSummary) {
//        this.orderSummaryItem = orderSummary;
        this.orderSummaryName = new ArrayList<>();
        this.orderSummaryQuantity = new ArrayList<>();
        this.orderSummaryPrice = new ArrayList<>();

    }

    public void takeNote(String name, int newQuantity, double unitPrice, boolean token) {

        if (token) {
//            double itemTotalPrice = newQuantity * unitPrice;
//            // Lembrar que aqui defino um tamanho máximo para o texto do item, evitando itens de nome menor que o tamanho minimo.
//            int NAME_MIN_LENGTH = 15;
//            String noteLine = "\n" + String.valueOf(newQuantity) + "*\t" + (name.length() < NAME_MIN_LENGTH ? name : name.substring(0, NAME_MIN_LENGTH)) + "\t\tR$" + String.valueOf(unitPrice) + "\t\tR$" + String.valueOf(itemTotalPrice);

            //Se já tem o nome do item na lista, ele ja foi selecionado antes. Como não contém, adiciona:
            if (!orderSummaryName.contains(name)) {

                // Sendo um item novo na lista já existente, adicionar seus tres atributos.
//                orderSummaryItem.add(noteLine);
                orderSummaryName.add(name);
                orderSummaryQuantity.add(newQuantity);
                orderSummaryPrice.add(unitPrice);

                // Sempre ao final adicionando o valor total to pedido.
//                orderSummaryItem.set(0, String.valueOf(orderTotalPrice));

            } else {
                // Agora o objetivo é substituir os campos apropriados,
                // e por fim substituir o totalPrice ao final.
                // Começo obtendo o index na lista de nomes para atualizar na lista de pedidos*/
                int index = orderSummaryName.indexOf(name);

                if (newQuantity != 0) {
//                    orderSummaryItem.set(index, noteLine);
//                    orderSummaryItem.set(0, String.valueOf(orderTotalPrice));
                    orderSummaryQuantity.set(index, newQuantity);


                } else {
//                    orderSummaryItem.remove(index);
                    orderSummaryName.remove(index);
                    orderSummaryQuantity.remove(index);
                    orderSummaryPrice.remove(index);

//                    orderSummaryItem.set(0, String.valueOf(orderTotalPrice));
                }
            }
        }
    }

    // É importante ter em mente que aqui o objetivo é escrever os pedidos (linha a linha) e ao final adicionar o valor q deverá ser somado..
//    public String makeText() {
//        String note = "";
//        for (int i = 1; i < orderSummaryItem.size(); i++) {
//            note += orderSummaryItem.get(i);
//        }
//        note += "\nTotal R$ " + orderSummaryItem.get(0);
//        return note;
//    }

    public ArrayList<String> getOrderSummaryName() {
        return orderSummaryName;
    }

    public String makeTextForResume() {
        // Lembrar que aqui defino um tamanho máximo para o texto do item, evitando itens de nome menor que o tamanho minimo.
        int NAME_MIN_LENGTH = 15;
        String noteLine = "Resumo:";
        for (int i = 0; i < orderSummaryName.size(); i++) {
            String name = orderSummaryName.get(i);
            double itemTotalPrice = orderSummaryQuantity.get(i) * orderSummaryPrice.get(i);
            noteLine += "\n" + orderSummaryQuantity.get(i) + "*\t" + (name.length() < NAME_MIN_LENGTH ? name : name.substring(0, NAME_MIN_LENGTH)) + "\t\tR$" + String.valueOf(itemTotalPrice);
        }
        return noteLine;
    }

    public Order generateOrder(int tableNumber, String observationNotes) {
        ArrayList<String> aux1 = new ArrayList<>(orderSummaryName);
        ArrayList<Integer> aux2 = new ArrayList<>(orderSummaryQuantity);
        ArrayList<Double> aux3 = new ArrayList<>(orderSummaryPrice);
        orderSummaryName.clear();
        orderSummaryQuantity.clear();
        orderSummaryPrice.clear();
        return new Order(tableNumber, observationNotes, aux1, aux2, aux3);
    }
}
