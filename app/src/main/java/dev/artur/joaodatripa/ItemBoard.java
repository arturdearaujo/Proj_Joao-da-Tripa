package dev.artur.joaodatripa;

import java.util.List;

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

    private List<String> orders;

    private double totalPrice;

    public ItemBoard() {
    }


    public void takeNote(String name) {
        //Se o produto ainda não estiver anotado: anotar -> exibir informação.
        //
        // Se já estiver anotado:
        //      Se a quantidade de pedidos for igual a 0: remova anotação -> atualizar tela.
        //      Se diferente de zero: não faça nada.*/

    }
}
