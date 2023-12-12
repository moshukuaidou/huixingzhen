package com.example.huixingzhen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.ArrayList;

public class MainActivityAdapter extends FragmentStateAdapter {
    List<Fragment> fragmentList = new ArrayList<>();

    public MainActivityAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        this.fragmentList = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
        //返回fragment
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
        //返回总大小
    }

}
