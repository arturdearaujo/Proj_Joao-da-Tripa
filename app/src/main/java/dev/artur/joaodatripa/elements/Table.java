package dev.artur.joaodatripa.elements;

import android.text.TextUtils;

/**
 * Table class.
 * Created by artur on 05/08/2017.
 */

public class Table {

    /**
     * Constants
     */
    public final String AVAILABLE_TABLE = "Disponível";
    public final String RESERVED_TABLE = "Reservado";
    public final String OCCUPIED_TABLE = "Ocupado";

    /**
     * The number of the table for sorting.
     */
    private int number;

    /**
     * The name of the main client responsible for that table.
     */
    private String mainClientName;

    /**
     * The label to puc in the grid item.
     */
    private String tableTittle;

    /**
     * Public constructor for a Table object.
     *
     * @param number the index of the tables in the saloon.
     */
    public Table(int number) {
        this.number = number;
        setTableTittle(AVAILABLE_TABLE);
    }

    public int getNumber() {
        return number;
    }

    public String getTableTittle() {
        return tableTittle;
    }

    /**
     * This methods sets up the status of the table displayed in the GridView.
     *
     * @param status used to select the status as one of the constants, os with the name
     *               of the client, if previously provided.
     */
    public void setTableTittle(String status) {
        switch (status) {
            case RESERVED_TABLE:
                tableTittle = RESERVED_TABLE;
                break;
            case OCCUPIED_TABLE:
                if (hasNamedClient()) {
                    tableTittle = mainClientName;
                } else {
                    tableTittle = OCCUPIED_TABLE;
                }
                break;
            default:
            case AVAILABLE_TABLE:
                tableTittle = AVAILABLE_TABLE;
                break;
        }
    }

    private boolean hasNamedClient() {
        return !TextUtils.isEmpty(mainClientName);
    }

    public void setMainClientName(String mainClientName) {
        this.mainClientName = mainClientName;
    }
}
