package com.example.resistrationfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        ViewPager viewPager = (ViewPager) findViewById(R.id.myArea);

        FragmentManager fragmentManager = getSupportFragmentManager();

        MyPagerAdapter fragmentPagerAdapter = new MyPagerAdapter(fragmentManager);

        fragmentPagerAdapter.addFragment(Registration.newInstance() , "Form 1");
        fragmentPagerAdapter.addFragment(Details.newInstance() , "Form 2");

        viewPager.setAdapter(fragmentPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> stringList = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        public void addFragment(Fragment fragment , String title){
            fragmentList.add(fragment);
            stringList.add(title);
        }
    }
}