package com.mcas2.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mcas2.misaficiones.databinding.ActivityAficionesBinding;
import com.mcas2.misaficiones.ui.frmanager.Paginador;

import java.util.ArrayList;
import java.util.List;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;
    private List<String> favoritesList = new ArrayList<>();
    private FavoritosFragment favoritosFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        favoritosFragment = new FavoritosFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, favoritosFragment)
                .commit();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentFragment = paginador.getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addToFavorites(Fragment fragment) {
        String fragmentName = fragment.getClass().getSimpleName();
        if (!favoritesList.contains(fragmentName)) {
            favoritesList.add(fragmentName);
            favoritosFragment.setFavoritesList(favoritesList);
            Toast.makeText(this, fragmentName + " agregado a favoritos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, fragmentName + " ya está en favoritos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favButton) {
            if (currentFragment != null) {
                addToFavorites(currentFragment);
            } else {
                Toast.makeText(this, "No hay fragmento seleccionado", Toast.LENGTH_SHORT).show();
            }
        }

        if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(Aficiones.this, Ejercicio.class);
            startActivity(intent);
        }

        if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/jers2305/"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
