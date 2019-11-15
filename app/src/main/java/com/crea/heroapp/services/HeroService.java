package com.crea.heroapp.services;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.crea.heroapp.activities.MainActivity;
import com.crea.heroapp.common.Constants;
import com.crea.heroapp.interfaces.HeroServiceListener;
import com.crea.heroapp.models.Hero;
import com.crea.heroapp.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HeroService {

    private HeroServiceListener listener;

    public HeroService(HeroServiceListener listener) {
        this.listener = listener;
    }

    /*
     * Fetch API OR Fetch DataBase
     * */

    // Get Hero By Name
    public ArrayList<Hero> getHeroByName(String name) {

        // Fetch API
        // Volley
        String url = Constants.APIConfig.END_POINT_SEARCH_NAME + name;
        loadFromAPI(url);
        // Fetch DataBase

        return null;
    }

    private void loadFromAPI(String url) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MainActivity.MAIN_CONTEXT);
        // Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        Util.Log("HeroService", response.toString());

                        ArrayList<Hero> heros = new ArrayList<Hero>();

                        try {
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject jsonObject = results.getJSONObject(i);

                                Long id = jsonObject.getLong("id");
                                String name = jsonObject.getString("name");
                                String url = jsonObject.getJSONObject("image").getString("url");

                                Hero hero = new Hero();
                                hero.setId(id);
                                hero.setName(name);
                                hero.setUrl(url);

                                heros.add(hero);
                            }

                            if (heros.size() > 0) {
                                HeroService.this.listener.responseWithSuccess(heros);
                            } else {
                                HeroService.this.listener.responseWithError("No Hero Found");
                            }

                        } catch (JSONException jse) {
                            Util.Log("HeroService", jse.getMessage());
                            HeroService.this.listener.responseWithError(jse.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Util.Log("HeroService", error.getMessage());
                HeroService.this.listener.responseWithError(error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    // Get Hero By ID
    public Hero getHeroByID(int id) {

        return new Hero();
    }

    // Get Hero by Power
    public ArrayList<Hero> getHeroByPower(String power) {

        return null;
    }

}

