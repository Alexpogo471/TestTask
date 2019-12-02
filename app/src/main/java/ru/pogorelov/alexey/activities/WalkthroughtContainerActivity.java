package ru.pogorelov.alexey.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import ru.pogorelov.alexey.R;
import ru.pogorelov.alexey.adapter.ViewPagerAdapter;

public class WalkthroughtContainerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button buttonNext, buttonInputData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough_container);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        buttonNext = findViewById(R.id.buttonNext);
        buttonInputData = findViewById(R.id.buttonInputData);
        tabLayout.setupWithViewPager(viewPager, true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 5){
                    buttonInputData.setVisibility(View.VISIBLE);
                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                } else buttonInputData.setVisibility(View.GONE);
                tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });

        buttonInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalkthroughtContainerActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
