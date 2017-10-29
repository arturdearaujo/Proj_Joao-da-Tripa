package dev.artur.joaodatripa.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import dev.artur.joaodatripa.R;
import dev.artur.joaodatripa.adapters.MyPagerAdapter;
import dev.artur.joaodatripa.elements.Order;
import dev.artur.joaodatripa.elements.Table;
import dev.artur.joaodatripa.fragments.ItemsFragment;
import dev.artur.joaodatripa.fragments.ProductsFragment;
import dev.artur.joaodatripa.fragments.TablesFragment;

public class MainActivity extends AppCompatActivity implements ItemsFragment.OnOrderingListener, TablesFragment.OnUpdateTableListener {

    static ArrayList<Table> tableArrayList = new ArrayList<>();

    Toolbar toolbar;
    ViewPager viewPager;
    MyPagerAdapter adapter;
    TabLayout tabLayout;

    ItemsFragment mItemsFragments;
    ProductsFragment productsFragment;
    TablesFragment mTablesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Set the toolbar.
        toolbar = (Toolbar) findViewById(R.id.main_tool_bar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

//        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tool_bar);
//        collapsingToolbar.setTitle("João da Tripa");

        // Find the view pager that will allow the user to swipe between fragments
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        adapter = new MyPagerAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        // Find the tab layout that shows the tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

        //Create the list of tables
        for (int i = 0; i < 9; i++) {
            tableArrayList.add(new Table(i + 1));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Table> getTables() {
        return tableArrayList;
    }

    @Override
    public void onOrdering(Order order) {
        // Jogar na table correta (quem recebe é a classe Table)
        tableArrayList.get(order.getTableNumber() - 1).receiveOrder(order);
    }

    @Override
    public void onUpdateTable(Table newTable) {
        tableArrayList.get(newTable.getNumber() - 1).updateValues(newTable);
    }
}
