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
package dev.artur.joaodatripa.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.elements.Table;

/**
 * Created by artur on 05/08/2017.
 *
 *      artur.at4@gmail.com
 */

public class TableAdapter extends ArrayAdapter<Table> {
    public TableAdapter(@NonNull Context context, @NonNull List<Table> tables) {
        super(context, 0, tables);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_table_item, parent, false);
        }
        // Get the {@link Item} object located at this position in the list
        final Table currentTable = getItem(position);


        TextView tableNumber = listItemView.findViewById(R.id.table_number);
        tableNumber.setText(String.valueOf("Mesa " + currentTable.getNumber()));

        TextView tableTittle = listItemView.findViewById(R.id.main_client_name);
        tableTittle.setText(currentTable.getTableTittle());

        return listItemView;
    }
}
