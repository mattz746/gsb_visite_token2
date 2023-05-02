package com.example.gsb_visite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Token implements Serializable {
    public String getToken() {
        return token;
    }

    @SerializedName("token")
    private String token;

    public String getBearerToken() {
        return "Bearer " + token;
    }
}

