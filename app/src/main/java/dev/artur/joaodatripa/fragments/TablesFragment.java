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
package dev.artur.joaodatripa.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.activities.MainActivity;
import dev.artur.joaodatripa.activities.TableActivity;
import dev.artur.joaodatripa.adapters.TableAdapter;
import dev.artur.joaodatripa.elements.Table;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_FIRST_USER;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    private static final int REQUEST_1 = 1;

    GridView listView;
    TableAdapter adapter;
    OnUpdateTableListener mListener;

    public TablesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tables, container, false);

//        //Create the list of tables
//        final ArrayList<Table> tableArrayList = new ArrayList<>();
//        for (int i = 0 ; i < 9 ; i++) {
//            tableArrayList.add(new Table(i +1));
// }
        //This precious function gets something from the MainActivity ^^'
        // ... = ((MainActivity)this.getActivity()).getSomething() /
        final ArrayList<Table> mTables = ((MainActivity) this.getActivity()).getTables();

        adapter = new TableAdapter(getContext(), mTables);
        listView = (GridView) rootView.findViewById(R.id.list_of_tables);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Criar um intent para abrir a activity da table com todos os seus pedidos?
                Intent tableIntent = new Intent(getContext(), TableActivity.class);
                tableIntent.putExtra("table data", mTables.get(position));
                startActivityForResult(tableIntent, REQUEST_1);
            }
        });

        // Get the intent of this table's activity.
        Intent tableIntent = getActivity().getIntent();
        // Get the item putted inside the intent.
        Table item = (Table) tableIntent.getSerializableExtra("new order");

        //...

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // This handy function refreshes the ListView.
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_1) {
//            if (resultCode == RESULT_FIRST_USER) {
//                Table newTable = (Table) data.getSerializableExtra("tableUpdate");
//                // Talvez o jeito aqui seja enviar outro intent para atualizar os valores na MainActivity...
//                mListener.onUpdateTable(newTable);
//
//            }
//        }
        if (requestCode == REQUEST_1) {
            switch (resultCode) {
                case RESULT_FIRST_USER:
                case RESULT_OK:
                    Table newTable = (Table) data.getSerializableExtra("tableUpdate");
                    if (newTable != null) {
                        mListener.onUpdateTable(newTable);
                    }
                    // Talvez o jeito aqui seja enviar outro intent para atualizar os valores na MainActivity...
                    Table amendedTable = (Table) data.getSerializableExtra("amendedTable");
                    if (amendedTable != null) {
                        mListener.onAmendTable(amendedTable);
                    }
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(getContext(), "teste", Toast.LENGTH_SHORT).show();
                    break;
            }
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (TablesFragment.OnUpdateTableListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnUpdateTableListener");
        }
    }

    public interface OnUpdateTableListener {
        void onUpdateTable(Table newTable);

        void onAmendTable(Table newTable);
    }
}
