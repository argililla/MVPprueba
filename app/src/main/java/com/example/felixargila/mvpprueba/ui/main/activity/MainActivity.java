package com.example.felixargila.mvpprueba.ui.main.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.ui.main.adapter.ViewPagerAdapter;
import com.example.felixargila.mvpprueba.ui.main.fragment.MainFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.home_ic,
            R.mipmap.trend_ic,
            R.mipmap.subs_ic,
            R.mipmap.account_ic
    };
    private ViewPagerAdapter adapter;
    private ActionBar actionBar;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        viewPager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager();
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }


    private void setupViewPager() {
        adapter.addFragment(MainFragment.newInstance("0"),"one");
        adapter.addFragment(MainFragment.newInstance("1"), "two");
        adapter.addFragment(MainFragment.newInstance("2"), "three");
        adapter.addFragment(MainFragment.newInstance("3"), "four");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Pulse ATRAS de nuevo para salir", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
