package dev.artur.joaodatripa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.adapters.TableAdapter;
import dev.artur.joaodatripa.elements.Table;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablesFragment extends Fragment {

    private static final String TAG = "TablesFragment";

    public TablesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_table, container, false);

        //Create the list of tables
        final ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            tables.add(new Table(i));
        }

        TableAdapter adapter = new TableAdapter(getContext(), tables);
        GridView listView = (GridView) rootView.findViewById(R.id.list_of_tables);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

}
