package com.rusili.assessment4post.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Why a singleton?
 */
public class RetrofitSingleton {
    // Base url isn't changing: static & final
    private static final String BASE_URL = "https://raw.githubusercontent.com/";

    private static Retrofit instance;

    /**
     * Why private constructor?
     * Using public static "constructor" so we don't want to
     * create new instances of this class.
     */
    private RetrofitSingleton() {
    }

    /**
     * getInstance() is common naming convention for getting a singleton
     */
    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance;
    }
}
