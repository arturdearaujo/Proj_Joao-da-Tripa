package dev.artur.joaodatripa.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dev.artur.joaodatripa.ItemsFragment;
import dev.artur.joaodatripa.ProductsFragment;
import dev.artur.joaodatripa.TablesFragment;

/**
 * MyPagerAdapter class for operates with TabLayout
 * <p>
 * Created by DEV02 on 02/08/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    /**
     * The number of tabs os the app.
     */
    final int PAGE_COUNT = 3;
    Context context;
    private String tabTitles[] = new String[]{"Mesas", "Cardápio", "Produtos"};

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TablesFragment();
        } else if (position == 1) {
            return new ItemsFragment();
        } else {
            return new ProductsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}