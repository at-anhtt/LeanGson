package com.example.anhtt.leangson.typetoken;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anhtt on 09/08/2015.
 */
public class ListHelper {
    @SerializedName("name")
    private String name;
    @SerializedName("version")
    private String version;
    @SerializedName("api")
    private String api;


    public String getApi() {
        return api;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
