package com.likhit.karobar.ui.scanDetails;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.karobar.base.BaseFragment;
import com.likhit.karobar.data.models.Scan;
import com.likhit.karobar.databinding.FragmentScanDetailsViewBinding;

public class ScanDetailsViewFragment extends BaseFragment {

    public static final String TAG = "ScanDetailsViewFragment";

    private FragmentScanDetailsViewBinding binding;
    private ScanDetailsAdapter adapter;

    private Scan scanItem;

    public ScanDetailsViewFragment() {
    }

    public static ScanDetailsViewFragment newInstance(Scan scanItem) {

        ScanDetailsViewFragment fragment = new ScanDetailsViewFragment();
        Bundle args = new Bundle();
        args.putSerializable("scan_item", scanItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.scanItem = (Scan) getArguments().getSerializable("scan_item");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScanDetailsViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        binding.tvScanTitle.setText(scanItem.getName());
        binding.tvScanSubTitle.setText(scanItem.getTag());
        String color = scanItem.getColor();
        if (color.equalsIgnoreCase("red")) {
            binding.tvScanSubTitle.setTextColor(Color.RED);
        } else if (color.equalsIgnoreCase("green")) {
            binding.tvScanSubTitle.setTextColor(Color.GREEN);
        }

        adapter = new ScanDetailsAdapter(getBaseActivity());
        adapter.setCriteriaList(scanItem.getCrieteria());
        binding.rvScanListView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false));
        binding.rvScanListView.setAdapter(adapter);

    }
}
