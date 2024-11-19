package com.mcas2.misaficiones;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mcas2.misaficiones.databinding.ActivityAficionesBinding;
import com.mcas2.misaficiones.databinding.ActivityTiposdormirBinding;
import com.mcas2.misaficiones.ui.frmanager.Paginador;
import com.mcas2.misaficiones.ui.frmanager.PaginadorTiposDormir;

public class TiposDormir extends AppCompatActivity {

    private ActivityTiposdormirBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiposdormirBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorTiposDormir paginador = new PaginadorTiposDormir(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        TabLayout tabLayout = binding.tiposDormirTabs;
        tabLayout.setupWithViewPager(viewPager);
    }
}