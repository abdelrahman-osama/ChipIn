package com.chipin.chipin;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.chipin.chipin.Fragments.DashboardFragment;
import com.chipin.chipin.Fragments.ExploreFragment;
import com.chipin.chipin.Fragments.HomeFragment;
import com.chipin.chipin.databinding.ActivityMainBinding;

import com.chipin.chipin.view.CaseObject;
import com.chipin.chipin.view.SDGObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new MapViewFragment(), "Home");
        adapter.addFragment(new ExploreFragment(), "Explore");
        adapter.addFragment(new DashboardFragment(), "Dashboard");

        binding.mainContainer.setAdapter(adapter);
        binding.mainContainer.setPagingEnabled(false);
        binding.mainContainer.setOffscreenPageLimit(3);

        // binding.mainContainer.addO

        binding.navigationView
                .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            binding.mainContainer.setCurrentItem(0, false);
                            break;
                        case R.id.navigation_explore:
                            binding.mainContainer.setCurrentItem(1, false);
                            break;
                        case R.id.navigation_dashbord:
                            binding.mainContainer.setCurrentItem(2, false);
                            break;
                        }
                        return true;
                    }
                });

    }

    public void seed() {
        SDGObject zeroHunger = new SDGObject();
        zeroHunger.setSdgTitle("Zero Hunger");
        zeroHunger.setSdgDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        zeroHunger.setSdgImage("url");

        SDGObject womenEmpowerment = new SDGObject();
        womenEmpowerment.setSdgTitle("Women Empowerment");
        womenEmpowerment.setSdgDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        womenEmpowerment.setSdgImage("url");

        CaseObject quenaWaterways = new CaseObject();
        quenaWaterways.setCaseTitle("Quena Waterway Project");
        quenaWaterways.setCaseDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArrayList<String> goals = new ArrayList();
        goals.add("Buy cement");
        goals.add("build construction base");
        goals.add("connect to water link");

        quenaWaterways.setCaseGoals(goals);

        quenaWaterways.setCaseLocation("Quena, Egypt");
        quenaWaterways.setProgressReached(0);
        quenaWaterways.setProgressTarget(10000);

        ArrayList<String> images = new ArrayList<>();
        images.add("img1");
        images.add("img2");
        quenaWaterways.setCaseImages(images);

        CaseObject aswanRevolvingFund = new CaseObject();
        aswanRevolvingFund.setCaseTitle("Quena Waterway Project");
        aswanRevolvingFund.setCaseDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArrayList<String> goals2 = new ArrayList();
        goals.add("Buy cement");
        goals.add("build construction base");
        goals.add("connect to water link");

        aswanRevolvingFund.setCaseGoals(goals);

        aswanRevolvingFund.setCaseLocation("Quena, Egypt");
        aswanRevolvingFund.setProgressReached(0);
        aswanRevolvingFund.setProgressTarget(10000);

        ArrayList<String> images2 = new ArrayList<>();
        images.add("img1");
        images.add("img2");
        aswanRevolvingFund.setCaseImages(images);
    }
}
