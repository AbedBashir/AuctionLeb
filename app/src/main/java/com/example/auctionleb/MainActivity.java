package com.example.auctionleb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.auctionleb.Adapters.VerticalRecyclerViewAdapter;
import com.example.auctionleb.Fragments.AddItem_fragment;
import com.example.auctionleb.Fragments.Favorite_fragment;
import com.example.auctionleb.Fragments.Home_fragment;
import com.example.auctionleb.Fragments.Profile_fragment;
import com.example.auctionleb.Fragments.Settings_fragment;
import com.example.auctionleb.Models.VerticalModel;
import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BubbleTabBar bubbleTabBar;
    RecyclerView rvVertical;

    private ArrayList<VerticalModel> mArrayList = new ArrayList<>();
    private VerticalRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVertical = findViewById(R.id.rvVertical);

        Fragment fragment = new Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();

        bubbleTabBar = findViewById(R.id.bubbleTabBar);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home_fragment()).commit();

        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                Fragment selectedFragment = new Fragment();
                switch (i) {
                    case (R.id.nav_home):
                        selectedFragment = new Home_fragment();
                        break;
                    case (R.id.nav_favorites):
                        selectedFragment = new Favorite_fragment();
                        break;
                    case (R.id.nav_AddItem):
                        selectedFragment =new AddItem_fragment();
                        break;
                    case (R.id.nav_settings):
                        selectedFragment = new Settings_fragment();
                        break;
                    case (R.id.nav_Profile):
                        selectedFragment = new Profile_fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            }
        });


////        rvVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
////        mAdapter = new VerticalRecyclerViewAdapter(this,mArrayList);
////        rvVertical.setAdapter(mAdapter);
////        setDataOnVerticalRecyclerView();
//    }
//
//    private void setDataOnVerticalRecyclerView() {
//        for (int i = 1; i <= 20; i++) {
//
//            VerticalModel mVerticalModel = new VerticalModel();
//
//            mVerticalModel.setTitle("Title " + i);
//
//            ArrayList<HorizontalModel> arrayList = new ArrayList<>();
//
//            for (int j = 0; j <= 30; j++) {
//                HorizontalModel mHorizontalModel = new HorizontalModel();
//                mHorizontalModel.setDescription("Description : " + j);
//                mHorizontalModel.setName("Name : " + j);
//                arrayList.add(mHorizontalModel);
//            }
//
//            mVerticalModel.setArrayList(arrayList);
//
//            mArrayList.add(mVerticalModel);
//
//        }
//        mAdapter.notifyDataSetChanged();
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {

                        case (R.id.nav_home):
                            selectedFragment = new Home_fragment();
                            break;
                        case (R.id.nav_favorites):
                            selectedFragment = new Favorite_fragment();
                            break;
                        case (R.id.nav_AddItem):
                            selectedFragment =new AddItem_fragment();
                            break;
                        case (R.id.nav_settings):
                            selectedFragment = new Settings_fragment();
                            break;
                        case (R.id.nav_Profile):
                            selectedFragment = new Profile_fragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };
}