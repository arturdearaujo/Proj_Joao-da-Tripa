package dev.artur.joaodatripa.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.activities.TableActivity;
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
        final View rootView = inflater.inflate(R.layout.fragment_tables, container, false);

        //Create the list of tables
        final ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            tables.add(new Table(i));
            // Se aqui eu resolvesse instanciar uma tableActivity para cada table, seria um pessimo uso de memoria para muitas mesas vazias...
        }

        TableAdapter adapter = new TableAdapter(getContext(), tables);
        GridView listView = (GridView) rootView.findViewById(R.id.list_of_tables);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: cliquei na mesa :/");
                Intent tableIntent = new Intent(getContext(), TableActivity.class);
                tableIntent.putExtra("table data", tables.get(position));
                startActivity(tableIntent);
            }
        });

        // Get the intent of this table's activity.
        Intent tableIntent = getActivity().getIntent();
        // Get the item putted inside the intent.
        Table item = (Table) tableIntent.getSerializableExtra("new order");
        // Inflate the layout for this fragment
        return rootView;
    }

}
