package dev.artur.joaodatripa;

import java.util.ArrayList;

/**
 * ItemBoard class. ["caderneta de pedidos"]
 * <p>
 * Classe criada com a finalidade de abstrair uma caderneta onde se anotam todos os pedidos
 * a serem realizados pelo cliente. O objetivo principal seria implementar uma lógica que
 * entregue a um TextView a lista de pedidos realizados do cardápio.
 * <p>
 * Created by artur on 16/08/2017.
 */

public class ItemBoard {

    private final ArrayList<String> orderSummaryItem;
    private ArrayList<String> orderSummaryName;

    public ItemBoard(ArrayList<String> orderSummary) {
        this.orderSummaryItem = orderSummary;
        this.orderSummaryName = new ArrayList<>();

    }

    public String takeNote(String name, int newQuantity, double unitPrice, double orderTotalPrice, boolean token) {

        if (token) {
            double itemTotalPrice = newQuantity * unitPrice;
            String noteLine = "\n" + String.valueOf(newQuantity) + "*\t" + (name.length() < 10 ? name : name.substring(0, 10)) + "\t\tR$" + String.valueOf(unitPrice) + "\t\tR$" + String.valueOf(itemTotalPrice);

            //Se já tem o nome do item na lista, ele ja foi selecionado antes. Como não contém, adiciona:
            if (!orderSummaryName.contains(name)) {

                //Se é a primeira vez q adiciona qualquer item, adicionar na posição 0 o valor total.
                if (orderSummaryItem.size() == 0) {
                    orderSummaryItem.add(0, String.valueOf(orderTotalPrice));
                    orderSummaryName.add(0, String.valueOf(orderTotalPrice));
                }

                // Sendo um item novo na lista já existente, adicionar seus tres atributos.
                orderSummaryItem.add(noteLine);
                orderSummaryName.add(name);
                orderSummaryItem.set(0, String.valueOf(orderTotalPrice));


                return makeText();
            } else {
                // Aqui o objetivo é criar uma nova string no mesmo formato, substituindo os campos apropriados,
                // e por fim substituindo a linha inteira onde foi armazenado o item já existente.
                // Começo obtendo o index na lista de nomes para atualizar na lista de pedidos*/
                int index = orderSummaryName.indexOf(name);

                if (newQuantity != 0) {
                    orderSummaryItem.set(index, noteLine);
                    orderSummaryItem.set(0, String.valueOf(orderTotalPrice));
                } else {
                    orderSummaryItem.remove(index);
                    orderSummaryName.remove(index);
                    orderSummaryItem.set(0, String.valueOf(orderTotalPrice));
                }

                return makeText();
            }
        }
        return makeText();
    }

    public String makeText() {
        String note = "Resumo:";
        for (int i = 1; i < orderSummaryItem.size(); i++) {
            note += orderSummaryItem.get(i);
        }
        note += "\nTotal R$ " + orderSummaryItem.get(0);
        return note;
    }

}
