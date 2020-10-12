package com.example.resistrationfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

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

        final ProfilePojo profile = new ProfilePojo();
        profile.username = "Khushboo Shetkar";
        profile.phoneNumber = "9923810760";
        profile.emailId = "khush@gmail.com";
        profile.password = "khush123";
        profile.gender = "female";
        profile.district = "North Goa";
        profile.date = "30/04/1997";

        AppCompatImageButton button = (AppCompatImageButton) findViewById(R.id.done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout part1 = (RelativeLayout) findViewById(R.id.part1);
                RelativeLayout part2 = (RelativeLayout) findViewById(R.id.part2);

                TextInputEditText nm , phn , eml , pswd1 , pswd2 , dob;

                TextView unm;

                RadioButton gender;

                Spinner dist;

                nm = (TextInputEditText) part1.findViewById(R.id.edit_name);
                nm.setText(profile.username);

                phn = (TextInputEditText) part1.findViewById(R.id.edit_phone);
                phn.setText(profile.phoneNumber);

                eml = (TextInputEditText) part1.findViewById(R.id.edit_email);
                eml.setText(profile.emailId);

                pswd1 = (TextInputEditText) part1.findViewById(R.id.edit_password);
                pswd1.setText(profile.password);

                pswd2 = (TextInputEditText) part1.findViewById(R.id.edit_password2);
                pswd2.setText(profile.password);

                unm = (TextView) part2.findViewById(R.id.nameArea);
                unm.setText(profile.username);

                if(profile.gender == "female")
                    gender = (RadioButton) part2.findViewById(R.id.f);
                else if(profile.gender == "male")
                    gender = (RadioButton) part2.findViewById(R.id.m);
                else
                    gender = (RadioButton) part2.findViewById(R.id.o);
                gender.setChecked(true);

                dist = (Spinner) part2.findViewById(R.id.district);
                //

                dob = (TextInputEditText) part2.findViewById(R.id.dob);
                dob.setText(profile.date);

            }
        });



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