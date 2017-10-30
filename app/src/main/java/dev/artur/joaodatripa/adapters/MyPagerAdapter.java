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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dev.artur.joaodatripa.fragments.ItemsFragment;
import dev.artur.joaodatripa.fragments.ProductsFragment;
import dev.artur.joaodatripa.fragments.TablesFragment;

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
    private ItemsFragment mItemsFragments;
    private ProductsFragment mProductsFragments;
    private TablesFragment mTablesFragments;
    private String tabTitles[] = new String[]{"Mesas", "Cardápio", "Produtos"};

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mItemsFragments = new ItemsFragment();
        mProductsFragments = new ProductsFragment();
        mTablesFragments = new TablesFragment();
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
