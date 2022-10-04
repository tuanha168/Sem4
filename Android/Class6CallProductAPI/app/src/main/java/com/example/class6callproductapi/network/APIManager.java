package com.example.class6callproductapi.network;

import com.example.class6callproductapi.model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIManager {

    String SERVER_URL = "http://127.0.0.1:8082";
    //String SERVER_URL = "https://data.usajobs.gov";

    @GET("/ProductAPI_war/getcustInfo/")
    Call<List<Customer>> getListCustomer(@Query("page") String page);

    @POST("/ProductAPI_war/postcustInfo/")
    Call<Customer> savePost(@Body Customer post);
}
