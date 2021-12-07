package com.example.projectotis.main;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectotis.FragmentOneInnerTest;
import com.example.projectotis.FragmentThree;
import com.example.projectotis.FragmentThreeInnerTest;
import com.example.projectotis.FragmentTwoInnerTest;
import com.example.projectotis.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterInnerFrags3 extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final FragmentThree mContext;

    public SectionsPagerAdapterInnerFrags3(FragmentThree fragmentThree, FragmentManager fm) {
        super(fm);
        mContext = fragmentThree;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);


        Fragment fragment = null;

        switch(position)
        {
            case 0:
                fragment = new FragmentOneInnerTest();
                break;
            case 1:
                fragment = new FragmentTwoInnerTest();
                break;
            case 2:
                fragment = new FragmentThreeInnerTest();
                break;


        }
        return fragment;



        /*
        switch(position)
        {
            case 0:
                fragment = new FragmentOne();
                switch (position)
                {
                    case 0:
                        fragment = new FragmentOne();
                        break;
                    case 1:
                        fragment = new FragmentTwo();
                        break;
                    case 2:
                        fragment = new FragmentThree();
                        break;
                }
                break;
            case 1:
                fragment = new FragmentTwo();
                switch (position)
                {
                    case 0:
                        fragment = new FragmentOne();
                        break;
                    case 1:
                        fragment = new FragmentTwo();
                        break;
                    case 2:
                        fragment = new FragmentThree();
                        break;
                }
                break;
            case 2:
                fragment = new FragmentThree();
                switch (position)
                {
                    case 0:
                        fragment = new FragmentOne();
                        break;
                    case 1:
                        fragment = new FragmentTwo();
                        break;
                    case 2:
                        fragment = new FragmentThree();
                        break;
                }
                break;


        }


        return fragment;

         */



    }



    /*
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

     */

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}