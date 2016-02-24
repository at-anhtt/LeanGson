package com.example.anhtt.leangson.typetoken;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.anhtt.leangson.MyHTML;
import com.example.anhtt.leangson.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhtt on 09/08/2015.
 */
public class MainList extends FragmentActivity {
    List<ListHelper> listHelpers;
    private String url = "http://serviceapi.skholingua.com/open-feeds/list_multipletext_json_formatted.php";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmain);
        showData();
    }

    public void showData() {
        listView = (ListView) findViewById(R.id.listMain);
        listHelpers = new ArrayList<>();
        new GsonType().execute();

    }

    public class GsonType extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String jsonStr = MyHTML.getData(url);
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new StringReader(jsonStr));

            try {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(jsonReader).getAsJsonObject();
                JsonArray jsonArray = jsonObject.getAsJsonArray("Android_Version_List");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject1 = (JsonObject) jsonArray.get(i);
                    ListHelper listHelper = gson.fromJson(jsonObject1, ListHelper.class);
                    listHelpers.add(listHelper);
                }

            } catch (Exception e) {
                e.getMessage();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            CustomAdapter adapter = new CustomAdapter(getApplication(),android.R.layout.simple_list_item_1,listHelpers);
            listView.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

}
