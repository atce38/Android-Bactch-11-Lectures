package com.abidingtech.www.androidbactch11.Lecture22;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.abidingtech.www.androidbactch11.Lecture21.fragments.ContactFragment;
import com.abidingtech.www.androidbactch11.Lecture21.fragments.HomeFragment;
import com.abidingtech.www.androidbactch11.Lecture21.fragments.ProfileFragment;

public class TabAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    public TabAdapter(@NonNull FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new ContactFragment();
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
