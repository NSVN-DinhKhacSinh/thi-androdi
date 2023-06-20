package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.fragment.FragmentNhapLop;
import com.example.myapplication.fragment.FragmentNhapSV;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentNhapSV();
            case 1:
                return new FragmentNhapLop();
//            default: new FragmentNhapSV();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
