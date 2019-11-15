package com.crea.heroapp.common;

public class Constants {

    public static final class APIConfig {
        private final static String API_KEY = "10215639321322627";
        private static final String URL_API_DOMAINE = "https://www.superheroapi.com/api.php/" + API_KEY;
        public static final String END_POINT_SEARCH_NAME = URL_API_DOMAINE + "/search/";
    }
}
