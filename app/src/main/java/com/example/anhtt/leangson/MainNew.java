package com.example.anhtt.leangson;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by anhtt on 09/08/2015.
 */
public class MainNew extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_mainnew);
        showData();
    }
    public void showData(){
        TextView textView = (TextView) findViewById(R.id.tvGson);
        Login login = new Login();
        login.setName("Tien Anh");
        login.setVersion("Asian tech");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(login);
        textView.setText(jsonStr);
    }

}
