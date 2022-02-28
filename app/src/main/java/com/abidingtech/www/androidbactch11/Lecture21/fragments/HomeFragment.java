package com.abidingtech.www.androidbactch11.Lecture21.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abidingtech.www.androidbactch11.Lecture21.NavActivity;
import com.abidingtech.www.androidbactch11.MainActivity;
import com.abidingtech.www.androidbactch11.R;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        NavActivity.setNavItemChecked(R.id.item1);
        getActivity().setTitle("Home");
        return view;
    }
}