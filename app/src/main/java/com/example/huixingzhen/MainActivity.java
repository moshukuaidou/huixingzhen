package com.example.huixingzhen;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.SQL.DbContect;
import com.example.edit.edit;
import com.example.list.Frag_List;
import com.example.list.MyAdapter;
import com.example.mine.mine;
import com.example.stats.stats;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private DbContect myDatabaseHelper  ;

    private static final int NUM_PAGES = 4;
    private FragmentStateAdapter pagerAdapter;
    public final List<Fragment> fragmentList = new ArrayList<>();
    public ViewPager2 viewPager;


    public void onItemClick(int position) {
         viewPager.setCurrentItem(1, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_vp);

        myDatabaseHelper = new DbContect(MainActivity.this);
        fragmentList.add(Frag_List.newInstance(" "," "));
        fragmentList.add(edit.newInstance(" "," "));

        fragmentList.add(stats.newInstance(" "," "));
        fragmentList.add(mine.newInstance(" "," "));

        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv);
        MainActivityAdapter adapter = new MainActivityAdapter(getSupportFragmentManager() , getLifecycle(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, true);
        viewPager.setCurrentItem(0, true);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.menu_list);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.menu_edit);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.menu_stats);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.menu_mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        bottomNavigationView.setOnItemSelectedListener (item -> {
            viewPager.setCurrentItem(getItemIdByMenuItem(item), true);
            return true;
        });



    }



    private int getItemIdByMenuItem(MenuItem item) {

        if (item.getItemId() == R.id.menu_list) {

            viewPager.setCurrentItem(0, true);
            return 0;
        } else if (item.getItemId() == R.id.menu_edit) {
            viewPager.setCurrentItem(1, true);
            return 1;
        } else if (item.getItemId() == R.id.menu_stats) {
            viewPager.setCurrentItem(2, true);
            return 2;
        } else if (item.getItemId() == R.id.menu_mine) {
            viewPager.setCurrentItem(3, true);
            return 3;
        }

        return 0;
    }


}


