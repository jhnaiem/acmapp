package com.example.jahid.acm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class dataFragment extends Fragment {
    View view;
    ViewPager viewPager;
    //TabLayout tabLayout;
    BottomNavigationView bottomBar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sample, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        bottomBar=view.findViewById(R.id.bottomBar1);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.notice_){
                    new contentFragment();

                    viewPager.setCurrentItem(0);
                }
                return false;
            }
        });
        bottomBar.setSelectedItemId(R.id.notice_);


//        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
//        tabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                tabLayout.setupWithViewPager(viewPager);
//            }
//        });
//
        return view;
    }
     class sliderAdapter extends FragmentPagerAdapter {

        //final String tabs[]={"Timeline", "ACM"};
        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {



            if (position == 0) {
                return new contentFragment();
            } else
               return new contentfragment2();



        }

        @Override
        public int getCount() {
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return " ";
        }
    }
}
