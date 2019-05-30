package com.likhit.karobar.data;

import com.likhit.karobar.data.models.Scan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/data")
    Call<List<Scan>> getScan();
}

