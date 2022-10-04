package com.example.class6callproductapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.class6callproductapi.adapter.ListNewsAdapter;
import com.example.class6callproductapi.model.Customer;
import com.example.class6callproductapi.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsActivity extends AppCompatActivity {

    ListView lvNews;
    ListNewsAdapter adapter;
    List<Customer> listNews = new ArrayList<>();
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        lvNews = findViewById(R.id.lvNews);

        //parserListCustomers();

        postCustomer();

//        btnCall = (Button) findViewById(R.id.btnCall);
//
//        btnCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //B1: Datasource
//                postCustomer();
//            }
//        });
    }

    private void postCustomer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.4:8082/ProductAPI_war/postcustInfo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.savePost(new Customer(0, "Nguyen Thanh Tuan", "tuan@gmail.com", "Hanoi")).
                enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    Log.i("post submitted to API: ", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });
    }

    private void parserListCustomers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.4:8082/ProductAPI_war/getcustInfo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getListCustomer("").enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {

                Log.d("parserListNews ", "Calling");

                List<Customer> list = response.body();
                for (Customer model: list) {
                    Log.d("parserListNews", model.getName());
                }

                // B2
                listNews = list;
                adapter = new ListNewsAdapter(listNews, ListNewsActivity.this);
                lvNews.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.d("parserListNews FAILED: ", t.getCause() + ", " +  t.getMessage() + ", " + t.getStackTrace() +", "+ t.getSuppressed());
            }
        });
    }
}
