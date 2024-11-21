package com.mcas2.misaficiones;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mcas2.misaficiones.databinding.ActivityEjercicioBinding;
import com.mcas2.misaficiones.ui.frmanager.PaginadorEjercicio;

public class Ejercicio extends AppCompatActivity {

    private ActivityEjercicioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEjercicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorEjercicio paginador = new PaginadorEjercicio(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        TabLayout tabLayout = binding.ejercicoTabs;
        tabLayout.setupWithViewPager(viewPager);
    }
}