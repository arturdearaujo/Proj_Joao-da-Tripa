package dev.artur.joaodatripa.data;

import android.provider.BaseColumns;

/**
 * Created by artur on 25/10/2017.
 */

public final class ProductsContract {

    private ProductsContract() {
    }

    public static final class ProductsEntry implements BaseColumns {

        /**
         * Name of database table for products
         */
        public final static String TABLE_NAME = "products";

        /**
         * Unique ID number for the pet (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_PRODUCT_NAME = "name";
        public final static String COLUMN_PRODUCT_PRICE = "price";
        public final static String COLUMN_PRODUCT_IMAGE_RESOURCE = "image_resource_id";
        public final static String COLUMN_PRODUCT_STOCK = "stock";
    }
}

