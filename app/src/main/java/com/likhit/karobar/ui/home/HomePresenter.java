package com.likhit.karobar.ui.home;

import android.support.annotation.NonNull;
import android.util.Log;

import com.likhit.karobar.base.BasePresenter;
import com.likhit.karobar.data.ApiClient;
import com.likhit.karobar.data.ApiService;
import com.likhit.karobar.data.models.Scan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Preseneter {

    public HomePresenter() {
    }

    @Override
    public void getScanList() {
        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        final Call<List<Scan>> request = service.getScan();
        request.enqueue(new Callback<List<Scan>>() {
            @Override
            public void onResponse(@NonNull Call<List<Scan>> call, @NonNull Response<List<Scan>> response) {
                Log.e("API", String.valueOf(response.body()));
                if (getView() != null && response.body() != null) {
                    getView().OnScanListReceived(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Scan>> call, @NonNull Throwable t) {
                Log.e("API", t.getMessage());
            }
        });
    }
}
