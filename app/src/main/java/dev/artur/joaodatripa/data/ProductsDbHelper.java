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
package dev.artur.joaodatripa.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by artur on 25/10/2017.
 */

public class ProductsDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = ProductsDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "products.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link ProductsDbHelper}.
     *
     * @param context of the app
     */
    public ProductsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + ProductsContract.ProductsEntry.TABLE_NAME + " ("
                + ProductsContract.ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductsContract.ProductsEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ProductsContract.ProductsEntry.COLUMN_PRODUCT_PRICE + " INTEGER NOT NULL, "
                + ProductsContract.ProductsEntry.COLUMN_PRODUCT_IMAGE_RESOURCE + " TEXT, "
                + ProductsContract.ProductsEntry.COLUMN_PRODUCT_STOCK + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
