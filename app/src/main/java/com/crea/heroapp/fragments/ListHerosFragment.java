package com.crea.heroapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crea.heroapp.R;
import com.crea.heroapp.interfaces.HeroServiceListener;
import com.crea.heroapp.models.Hero;
import com.crea.heroapp.services.HeroService;
import com.crea.heroapp.utils.Util;
import com.crea.heroapp.views.HeroRecyclerAdpater;

import java.util.ArrayList;

public class ListHerosFragment extends Fragment {

    private String seacheName;

    public ListHerosFragment(String searchName) {
        this.seacheName = searchName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_heros_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Load Data
        loadData();
    }

    private void loadData() {
        // Fetch Hero From HeroService
        new HeroService(new HeroServiceListener() {
            @Override
            public void responseWithSuccess(ArrayList<Hero> heros) {
                Util.Log("HeroService", heros.toString());
                showProgressBar(false);
                setupRecyclerView(heros);
            }

            @Override
            public void responseWithError(String erroMessage) {
                Util.Log("HeroService", erroMessage);
                showProgressBar(false);
                makeToast(erroMessage);
            }
        }).getHeroByName(this.seacheName);
    }

    private void makeToast(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }

    private void showProgressBar(boolean show) {
        ProgressBar progressBar = getView().findViewById(R.id.progressBar);
        progressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    private void setupRecyclerView(ArrayList<Hero> heros) {
        RecyclerView recyclerView = getView().findViewById(R.id.list_heros);
        recyclerView.setVisibility(View.VISIBLE);
        /*
         * SETUP RECYCLERVIEW
         * */
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // CustomAdapter
        recyclerView.setAdapter(new HeroRecyclerAdpater(heros));
        recyclerView.getAdapter().notifyDataSetChanged();
    }


}
