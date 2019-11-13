package com.crea.heroapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.crea.heroapp.R;
import com.crea.heroapp.utils.Util;
import com.crea.heroapp.utils.UtilNavigationFragment;

public class SearchHeroFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate view with layout
        View view = inflater.inflate(R.layout.search_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText searchEditText = view.findViewById(R.id.searchHeroName);

        Button valider = view.findViewById(R.id.validerSearchHeroNameButton);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = searchEditText.getText().toString();
                Util.Log("SearchHeroFragment", searchName);
                goToListHerosFragmentWithName(searchName);
            }
        });
    }

    private void goToListHerosFragmentWithName(String searchName) {
        ListHerosFragment listHerosFragment = new ListHerosFragment(searchName);
        UtilNavigationFragment.nextFragment(listHerosFragment, this.getActivity());
    }
}
