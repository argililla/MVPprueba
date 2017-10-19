package com.example.felixargila.mvpprueba.ui.main.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.presenter.main.MainPresenter;
import com.example.felixargila.mvpprueba.presenter.main.MainPresenterImp;
import com.example.felixargila.mvpprueba.ui.main.adapter.ViewPagerAdapter;
import com.example.felixargila.mvpprueba.ui.home.fragment.HomeFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainView{

    private MainPresenter presenter;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        presenter = new MainPresenterImp(this);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager();
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();



    }

    private void setupViewPager() {
        adapter.addFragment(HomeFragment.newInstance("0"),"one");
        adapter.addFragment(HomeFragment.newInstance("1"), "two");
        adapter.addFragment(HomeFragment.newInstance("2"), "three");
        adapter.addFragment(HomeFragment.newInstance("3"), "four");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);

    }



}
