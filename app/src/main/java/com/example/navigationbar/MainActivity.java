package com.example.navigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    List<View> lsViews = new ArrayList<>();
    MyPagerAdapter pagerAdapter;
    RadioButton rbChat, rbContact, rbDiscover, rbMe;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.main_vp);
        radioGroup = findViewById(R.id.main_rg);
        rbChat = findViewById(R.id.rb1);
        rbContact = findViewById(R.id.rb2);
        rbDiscover = findViewById(R.id.rb3);
        rbMe = findViewById(R.id.rb4);

        rbChat.setChecked(true);

        lsViews.add(getLayoutInflater().inflate(R.layout.page_one, null, false));
        lsViews.add(getLayoutInflater().inflate(R.layout.page_two, null, false));
        lsViews.add(getLayoutInflater().inflate(R.layout.page_three, null, false));
        lsViews.add(getLayoutInflater().inflate(R.layout.page_four, null, false));

        pagerAdapter = new MyPagerAdapter(lsViews);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //选中ViewPage页的时候触发该事件
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0://rb1
                        rbChat.setChecked(true);
                        break;
                    case 1://rb2
                        rbContact.setChecked(true);
                        break;
                    case 2://rb3
                        rbDiscover.setChecked(true);
                        break;
                    case 3://rb4
                        rbMe.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置Button选中的时候切换ViewPager
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }
}