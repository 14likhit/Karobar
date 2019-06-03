package com.likhit.karobar.ui.scanDetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.karobar.R;
import com.likhit.karobar.base.BaseFragment;
import com.likhit.karobar.data.models.VariableDetails;
import com.likhit.karobar.databinding.FragmentScanDetailsEditBinding;
import com.likhit.karobar.databinding.FragmentScanDetailsViewBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ScanDetailsEditFragment extends BaseFragment {

    public static final String TAG = "ScanDetailsViewFragment";

    private FragmentScanDetailsEditBinding binding;
    private ScanDetailsEditAdapter adapter;

    private VariableDetails var;

    public ScanDetailsEditFragment() {
    }

    public static ScanDetailsEditFragment newInstance(VariableDetails vB) {
        ScanDetailsEditFragment fragment = new ScanDetailsEditFragment();
        Bundle args = new Bundle();
        args.putSerializable("vd", vB);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.var = (VariableDetails) getArguments().getSerializable("vd");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScanDetailsEditBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        if (var != null && var.getType().equalsIgnoreCase("indicator")) {
            binding.rvScanListView.setVisibility(View.GONE);
            binding.tvScanTitle.setText(var.getStudyType().toUpperCase());
            binding.tvScanSetParameter.setText("Set Parameter: " + var.getParameterName());
        } else if (var != null && var.getType().equalsIgnoreCase("value")) {
            binding.layoutIndicator.setVisibility(View.GONE);
            adapter = new ScanDetailsEditAdapter(getBaseActivity());
            adapter.setValues(var.getValues());
            binding.rvScanListView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false));
            binding.rvScanListView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onBackPressed() {
        return super.onBackPressed();
    }
}
