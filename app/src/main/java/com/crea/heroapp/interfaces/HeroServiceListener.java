package com.crea.heroapp.interfaces;

import com.crea.heroapp.models.Hero;

import java.util.ArrayList;

public interface HeroServiceListener {

    public void responseWithSuccess(ArrayList<Hero> heros);
    public void responseWithError(String erroMessage);

}
