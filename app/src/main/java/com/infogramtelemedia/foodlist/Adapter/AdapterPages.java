package com.infogramtelemedia.foodlist.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.infogramtelemedia.foodlist.Fragments.IngredientsFragments;
import com.infogramtelemedia.foodlist.Fragments.InstructionsFragments;

public class AdapterPages extends FragmentPagerAdapter {

    int tabsNumber;

    public AdapterPages(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new IngredientsFragments();
            case 1:
                return new InstructionsFragments();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
