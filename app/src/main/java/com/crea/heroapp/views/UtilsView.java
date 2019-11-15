package com.crea.heroapp.views;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;


class UtilsView {

    public static void loadImageFromURL(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
