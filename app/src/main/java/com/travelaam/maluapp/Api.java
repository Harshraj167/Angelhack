package com.travelaam.maluapp;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String Base_url ="https://my-json-server.typicode.com/typicode/demo/";

    @GET("/db")
    Call<ResponseBody> getdb();

    @GET("/users")
    Call<ResponseBody> getUsers();

    @POST("/users")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);

}
