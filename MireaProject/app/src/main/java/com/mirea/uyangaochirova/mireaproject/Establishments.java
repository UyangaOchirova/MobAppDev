package com.mirea.uyangaochirova.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.Intent;

import com.mirea.uyangaochirova.mireaproject.databinding.FragmentEstablishmentsBinding;

public class Establishments extends Fragment {
    private FragmentEstablishmentsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEstablishmentsBinding.inflate(inflater, container, false);

        setButtons();

        return binding.getRoot();
    }

    private void setButtons() {
        binding.buttonShow1.setOnClickListener(v -> StartMap(
                "Общежитие",
                "Студенческая 33к4",
                55.739194, 37.543291
        ));

        binding.buttonShow2.setOnClickListener(v -> StartMap(
                "Библиотека",
                "Кутузовский проспект 24",
                55.744531, 37.545267));

        binding.buttonShow3.setOnClickListener(v -> StartMap(
                "РГБМ",
                "Большая Черкизовская 4к1",
                55.795940, 37.718247));

        binding.buttonShow4.setOnClickListener(v -> StartMap(
                "Светловка" ,
                "Большая Садовая 1",
                55.766666, 37.591193));
    }

    private void StartMap(String title, String description, double latitude, double longitude) {
        Intent intent = new Intent(getActivity(), Map.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}