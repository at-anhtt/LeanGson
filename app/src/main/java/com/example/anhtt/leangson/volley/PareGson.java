package com.example.anhtt.leangson.volley;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.anhtt.leangson.R;
import com.example.anhtt.leangson.typetoken.ListHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhtt on 09/08/2015.
 */
public class PareGson extends FragmentActivity {
    private VolleyHelper volleyHelper;
    private String url = "http://serviceapi.skholingua.com/open-feeds/list_multipletext_json_formatted.php";
    List<ListHelper> listHelpers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmain);
        showData();
    }

    public void showData() {
        listHelpers = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e("ttt", jsonObject.toString());
                        Gson gson = new Gson();

                        JsonReader jsonReader = new JsonReader(new StringReader(String.valueOf(jsonObject)));

                        try {
                            JsonParser jsonParser = new JsonParser();
                            JsonObject jsonObject2 = jsonParser.parse(jsonReader).getAsJsonObject();
                            JsonArray jsonArray = jsonObject2.getAsJsonArray("Android_Version_List");
                            for (int i = 0; i < jsonArray.size(); i++) {
                                JsonObject jsonObject1 = (JsonObject) jsonArray.get(i);
                                ListHelper listHelper = gson.fromJson(jsonObject1, ListHelper.class);
                                listHelpers.add(listHelper);

                            }

                        } catch (Exception e) {
                            e.getMessage();
                        }
                        Log.d("nam hello :", listHelpers.size()+"");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        // add class volley vao day nhe
        volleyHelper.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}
