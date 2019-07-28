package com.adgvit.task4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit;
        final String BASE_URL = "https://abhayrpatellist.herokuapp.com";
        retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        GetData service = retrofit.create(GetData.class);
        Call<List<data>> call = service.getList();
        call.enqueue(new Callback<List<data>>()
        {
            @Override
            public void onResponse(Call<List<data>> call, Response<List<data>> response)
            {
                if(response.isSuccessful())
                {
                   List<data> details=response.body();
                    RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recycleview);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    RecyclerView.Adapter adapter=new MyAdapter(details,getApplicationContext());
                    mRecyclerView.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),response.code(),Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<data>> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
