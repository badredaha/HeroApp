package com.crea.heroapp.interfaces;

import com.crea.heroapp.models.Hero;

import java.util.ArrayList;

public interface HeroServiceListener {

    void responseWithSuccess(ArrayList<Hero> heros);

    void responseWithError(String erroMessage);

}
