package com.likhit.karobar.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.likhit.karobar.R;
import com.likhit.karobar.base.BaseActivity;
import com.likhit.karobar.data.models.Scan;
import com.likhit.karobar.databinding.ActivityHomeBinding;

import java.util.List;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private ActivityHomeBinding binding;
    private ScanAdapter adapter;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setupToolbar("Karobar", false);

        presenter = new HomePresenter();
        presenter.attachView(this);

        initViews();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void initViews() {
        adapter = new ScanAdapter(this);
        binding.rvScanList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvScanList.setAdapter(adapter);
        presenter.getScanList();
    }

    @Override
    public void OnScanListReceived(List<Scan> scanList) {
        if (scanList != null && scanList.size() > 0) {
            adapter.setScanList(scanList);
            adapter.notifyDataSetChanged();
        }
    }
}
