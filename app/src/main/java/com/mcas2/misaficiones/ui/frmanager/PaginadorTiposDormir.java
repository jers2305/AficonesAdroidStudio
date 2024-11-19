package com.mcas2.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mcas2.misaficiones.R;
import com.mcas2.misaficiones.fr.aficiones.Comer;
import com.mcas2.misaficiones.fr.aficiones.Dormir;
import com.mcas2.misaficiones.fr.tiposdormir.Nervioso;
import com.mcas2.misaficiones.fr.tiposdormir.Placidamente;

public class PaginadorTiposDormir extends FragmentPagerAdapter {

    private final Context mContext;

    public PaginadorTiposDormir(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @StringRes
    private static final int[] TITULOS = new int[]{
            R.string.tipodormir1,
            R.string.tipodormir2
    };

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Nervioso();
            case 1:
                return new Placidamente();
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
