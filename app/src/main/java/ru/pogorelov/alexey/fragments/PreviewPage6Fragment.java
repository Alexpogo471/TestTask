package ru.pogorelov.alexey.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.pogorelov.alexey.R;

public class PreviewPage6Fragment extends Fragment {


    public PreviewPage6Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { ;

        getActivity().findViewById(R.id.buttonInputData).setVisibility(View.VISIBLE);

        return inflater.inflate(R.layout.fragment_preview_page6, container, false);
    }

}
