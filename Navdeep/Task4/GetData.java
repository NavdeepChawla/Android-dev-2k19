package com.adgvit.task4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData
{
    @GET("/list")
    Call<List<data>> getList();
}
