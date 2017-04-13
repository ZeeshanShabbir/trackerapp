package io.droidninja.trackerapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.droidninja.trackerapp.R;
import io.droidninja.trackerapp.fragments.SettingFragment;
import io.droidninja.trackerapp.fragments.ContactsFragment;
import io.droidninja.trackerapp.fragments.DiaryFragment;
import io.droidninja.trackerapp.fragments.ExploreFragment;
import io.droidninja.trackerapp.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    protected ViewPager viewPager;

    @BindView(R.id.tabs)
    protected TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new HomeFragment();
            else if (position == 1)
                return new DiaryFragment();
            else if (position == 2)
                return new ContactsFragment();
            else if (position == 3)
                return new ExploreFragment();
            else
                return new SettingFragment();
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0)
                return "HOME";
            else if (position == 1)
                return "DIARY";
            else if (position == 2)
                return "CONTACTS";
            else if (position == 3)
                return "EXPLORE";
            else
                return "SETTINGS";
        }
    }

}
