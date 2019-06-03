package com.likhit.karobar.ui.scanDetails;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.likhit.karobar.R;
import com.likhit.karobar.databinding.LayoutScanItemBinding;

import java.util.List;

public class ScanDetailsEditAdapter extends RecyclerView.Adapter<ScanDetailsEditAdapter.ScanDetailsEditViewHolder> {

    private List<Float> values;

    private LayoutInflater layoutInflater;

    private Context context;

    public ScanDetailsEditAdapter(Context context) {
        this.context = context;
    }

    public void setValues(List<Float> values) {
        this.values = values;
    }

    @NonNull
    @Override
    public ScanDetailsEditViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ScanDetailsEditAdapter.ScanDetailsEditViewHolder(layoutInflater.inflate(R.layout.layout_scan_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScanDetailsEditViewHolder scanDetailsEditViewHolder, int i) {
        final String value = String.valueOf(values.get(i));
        scanDetailsEditViewHolder.binding.tvScanTitle.setText(value);
        scanDetailsEditViewHolder.binding.tvScanSubTitle.setVisibility(View.GONE);
        scanDetailsEditViewHolder.binding.ivBullet.setVisibility(View.GONE);
        scanDetailsEditViewHolder.binding.layoutScanItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked " + value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (values != null && values.size() > 0) {
            return values.size();
        }
        return 0;
    }

    public class ScanDetailsEditViewHolder extends RecyclerView.ViewHolder {

        private LayoutScanItemBinding binding;

        public ScanDetailsEditViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
