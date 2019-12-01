package ru.pogorelov.alexey.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ru.pogorelov.alexey.fragments.PreviewPage1Fragment;
import ru.pogorelov.alexey.fragments.PreviewPage2Fragment;
import ru.pogorelov.alexey.fragments.PreviewPage3Fragment;
import ru.pogorelov.alexey.fragments.PreviewPage4Fragment;
import ru.pogorelov.alexey.fragments.PreviewPage5Fragment;
import ru.pogorelov.alexey.fragments.PreviewPage6Fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PreviewPage1Fragment();
            case 1:
                return new PreviewPage2Fragment();
            case 2:
                return new PreviewPage3Fragment();
            case 3:
                return new PreviewPage4Fragment();
            case 4:
                return new PreviewPage5Fragment();
            case 5:
                return new PreviewPage6Fragment();
            default:
                return new PreviewPage1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
