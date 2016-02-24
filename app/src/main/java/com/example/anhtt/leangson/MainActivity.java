package com.example.anhtt.leangson;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.anhtt.leangson.typetoken.MainList;
import com.example.anhtt.leangson.volley.PareGson;
import com.google.gson.Gson;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
  private String url="http://serviceapi.skholingua.com/open-feeds/simple_json.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnclick = (Button) findViewById(R.id.btnClick);
        btnclick.setOnClickListener(this);
        Button btnClick2 = (Button) findViewById(R.id.btnclick2);
        btnClick2.setOnClickListener(this);
        new GsonPare().execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClick:
                Intent intent = new Intent(this,PareGson.class);
                startActivity(intent);
                break;
            case R.id.btnclick2:
                Intent intent1 = new Intent(this, MainList.class);
                startActivity(intent1);
                break;
        }
    }

    public class GsonPare extends AsyncTask<String ,String, Login>{

    @Override
    protected Login doInBackground(String... params) {
        String gsonStr = MyHTML.getData(url);
        Gson gson = new Gson();
        Login login = gson.fromJson(gsonStr,Login.class);

        return login;
    }

    @Override
    protected void onPostExecute(Login login) {
        Log.d("name and version :", login.getName() +" :" + login.getVersion());
        Log.d("nam :", login.getName());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}

}
