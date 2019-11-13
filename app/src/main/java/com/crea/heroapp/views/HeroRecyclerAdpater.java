package com.crea.heroapp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crea.heroapp.R;
import com.crea.heroapp.activities.MainActivity;
import com.crea.heroapp.models.Hero;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HeroRecyclerAdpater extends RecyclerView.Adapter<HeroRecyclerAdpater.CellViewHolder> {


    public static class CellViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView heroName;

        public CellViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.imageViewHeroCellView);
            // set URL HERO
            heroName = v.findViewById(R.id.heroNameCellView);
        }
    }

    private ArrayList<Hero> heros;

    public HeroRecyclerAdpater(ArrayList<Hero> heros) {
        this.heros = heros;
    }

    @NonNull
    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View Constructor- Inflater layout
        View view = LayoutInflater.from(MainActivity.MAIN_CONTEXT).inflate(R.layout.cell_view,parent,false);

        CellViewHolder viewHolder = new CellViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {
        Hero hero = this.heros.get(position);
        holder.heroName.setText(hero.getName());
        Picasso.get().load(hero.getUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return this.heros.size();
    }

}
