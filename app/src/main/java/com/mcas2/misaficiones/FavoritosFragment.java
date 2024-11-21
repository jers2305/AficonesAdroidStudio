package com.mcas2.misaficiones;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class FavoritosFragment extends Fragment {
    private LinearLayout favoritesContainer;
    private TextView emptyMessage;
    private List<String> favoritesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        favoritesContainer = view.findViewById(R.id.favorites_container);
        emptyMessage = view.findViewById(R.id.empty_message);
        updateFavorites();
        return view;
    }

    public void updateFavorites() {
        if (favoritesList == null || favoritesList.isEmpty()) {
            favoritesContainer.setVisibility(View.GONE);
            emptyMessage.setVisibility(View.VISIBLE);
        } else {
            emptyMessage.setVisibility(View.GONE);
            favoritesContainer.setVisibility(View.VISIBLE);
            favoritesContainer.removeAllViews();
            for (String favorite : favoritesList) {
                TextView textView = new TextView(getContext());
                textView.setText(favorite);
                favoritesContainer.addView(textView);
            }
        }
    }

    public void setFavoritesList(List<String> favorites) {
        this.favoritesList = favorites;
        updateFavorites();
    }
}
