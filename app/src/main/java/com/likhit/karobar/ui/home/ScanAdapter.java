package com.likhit.karobar.ui.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.karobar.R;
import com.likhit.karobar.data.models.Scan;
import com.likhit.karobar.databinding.LayoutScanItemBinding;
import com.likhit.karobar.ui.scanDetails.ScanDetailsActivity;
import com.likhit.karobar.utils.AppConstants;

import java.util.List;

public class ScanAdapter extends RecyclerView.Adapter<ScanAdapter.ScanAdapterViewHolder> {

    private List<Scan> scanList;

    private LayoutInflater layoutInflater;

    private Context context;

    public ScanAdapter(Context context) {
        this.context = context;
    }

    public void setScanList(List<Scan> scanList) {
        this.scanList = scanList;
    }

    @NonNull
    @Override
    public ScanAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ScanAdapter.ScanAdapterViewHolder(layoutInflater.inflate(R.layout.layout_scan_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScanAdapterViewHolder scanAdapterViewHolder, int i) {
        final Scan scan = scanList.get(i);
        scanAdapterViewHolder.binding.tvScanTitle.setText(scan.getName());
        scanAdapterViewHolder.binding.tvScanSubTitle.setText(scan.getTag());
        String color = scan.getColor();
        if (color.equalsIgnoreCase(AppConstants.PARAMETER_COLOR_RED)) {
            scanAdapterViewHolder.binding.tvScanSubTitle.setTextColor(Color.RED);
        } else if (color.equalsIgnoreCase(AppConstants.PARAMETER_COLOR_GREEN)) {
            scanAdapterViewHolder.binding.tvScanSubTitle.setTextColor(Color.GREEN);
        }
        scanAdapterViewHolder.binding.layoutScanItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScanDetailsActivity.class);
                intent.putExtra(AppConstants.BUNDLE_KEY_SCAN_ACTIVITY, scan);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (scanList != null && scanList.size() > 0) {
            return scanList.size();
        }
        return 0;
    }

    public class ScanAdapterViewHolder extends RecyclerView.ViewHolder {
        private LayoutScanItemBinding binding;

        public ScanAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
