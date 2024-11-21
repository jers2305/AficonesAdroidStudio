package com.mcas2.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mcas2.misaficiones.R;
import com.mcas2.misaficiones.fr.Ejercicio.EnCasa;
import com.mcas2.misaficiones.fr.Ejercicio.Gym;

public class PaginadorEjercicio extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorEjercicio(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @StringRes
    private static final int[] TITULOS = new int[]{
            R.string.Gym,
            R.string.EjercicioEnCasa
    };

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Gym();
            case 1:
                return new EnCasa();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TITULOS[position]);
    }
}
