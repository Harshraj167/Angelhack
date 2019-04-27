package com.travelaam.maluapp;

import android.app.VoiceInteractor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    final static String url = "https://my-json-server.typicode.com/typicode/demo/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ListView listView = findViewById(R.id.listview;*/

        //retrofit fetching data from json
       Retrofit ret = new Retrofit.Builder()

                .baseUrl(Api.Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = ret.create(Api.class);

        api.getdb().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RectrofitExample", response.body().string())
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

       /* Call<List<Hero>> call = api.getheros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();

                String[] heroNames = new String[heroes.size()];

               for (Hero h: heroes){
                    Log.d("name",h.getName());
                    Log.d("realname", h.getRealname());
                    Log.d("team",h.getTeam());
                    Log.d("firsgappearance",h.getFirstappearance());
                    Log.d("createdby",h.getCreatedby());
                    Log.d("publisher",h.getPublisher());
                    Log.d("imageurl",h.getImageurl());
                    Log.d("bio",h.getBio());
                }

            }



            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        })*/


        String json ={
            "name": "Captain America",
                "realname": "Steve Rogers",
                "team": "Avengers",
                "firstappearance": "1941"};

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json")),json);

        api.postUser(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RetrofitExample", response.body().string());

                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

}
