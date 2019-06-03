package com.likhit.karobar.ui.scanDetails;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.likhit.karobar.R;
import com.likhit.karobar.data.models.Criteria;
import com.likhit.karobar.data.models.VariableDetails;
import com.likhit.karobar.databinding.LayoutScanItemBinding;
import com.likhit.karobar.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class ScanDetailsAdapter extends RecyclerView.Adapter<ScanDetailsAdapter.ScanDetailsViewHolder> {

    private List<Criteria> criteriaList;

    private LayoutInflater layoutInflater;

    private Context context;

    private ScanDetailsAdapterListener listener;

    public ScanDetailsAdapter(Context context) {
        this.context = context;
        listener = (ScanDetailsAdapterListener) context;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @NonNull
    @Override
    public ScanDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ScanDetailsAdapter.ScanDetailsViewHolder(layoutInflater.inflate(R.layout.layout_scan_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScanDetailsViewHolder scanDetailsViewHolder, int i) {
        final Criteria criteria = criteriaList.get(i);
        if (criteria.getVariable() != null) {
            final List<String> variables = new ArrayList<>();
            variables.addAll(criteria.getVariable().keySet());
            String spanText = criteria.getText();
            final List<String> variableValue = new ArrayList<>();
            for (int var = 0; var < variables.size(); var++) {
                VariableDetails variableDetails = criteria.getVariable().get(variables.get(var));
                if (variableDetails.getType().equalsIgnoreCase(AppConstants.VARIABLE_KEY_INDICATOR)) {
                    variableValue.add(String.valueOf(variableDetails.getDefaultValue()));
                    spanText = placeValuetypeIndicator(variableDetails, variables.get(var), spanText);
                } else if (variableDetails.getType().equalsIgnoreCase(AppConstants.VARIABLE_KEY_VALUE)) {
                    variableValue.add(String.valueOf(variableDetails.getValues().get(0)));
                    spanText = placeValuetypeValue(variableDetails, variables.get(var), spanText);
                }
            }

            SpannableStringBuilder spanTxt = new SpannableStringBuilder(spanText);
            List<Integer> variable = new ArrayList<>();
            for (int var = 0; var < variableValue.size(); var++) {
                variable.add(spanTxt.toString().indexOf(variableValue.get(var)));
            }

            for (int pt = 0; pt < variable.size(); pt++) {
                final int finalPt = pt;
                spanTxt.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
//                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                        VariableDetails variableDetails = criteria.getVariable().get(variables.get(finalPt));
                        if (variableDetails.getType().equalsIgnoreCase(AppConstants.VARIABLE_KEY_INDICATOR)) {
                            listener.launchScanDetailsEdit(variableDetails);

                        } else if (variableDetails.getType().equalsIgnoreCase(AppConstants.VARIABLE_KEY_VALUE)) {
                            listener.launchScanDetailsEdit(variableDetails);
                        }
                    }
                }, variable.get(pt), variable.get(pt) + variableValue.get(pt).length(), 0);
            }
            scanDetailsViewHolder.binding.tvScanTitle.setMovementMethod(LinkMovementMethod.getInstance());
            scanDetailsViewHolder.binding.tvScanTitle.setText(spanTxt, TextView.BufferType.SPANNABLE);
        } else {
            scanDetailsViewHolder.binding.tvScanTitle.setText(criteria.getText());
        }

        scanDetailsViewHolder.binding.tvScanSubTitle.setVisibility(View.GONE);

    }

    private String placeValuetypeIndicator(VariableDetails variableDetails, String key, String spanText) {
        return spanText.replace(key, variableDetails.getDefaultValue().toString());
    }

    private String placeValuetypeValue(VariableDetails variableDetails, String key, String spanText) {
        return spanText.replace(key, variableDetails.getValues().get(0).toString());
    }

    @Override
    public int getItemCount() {
        if (criteriaList != null && criteriaList.size() > 0) {
            return criteriaList.size();
        }
        return 0;
    }

    public class ScanDetailsViewHolder extends RecyclerView.ViewHolder {

        private LayoutScanItemBinding binding;

        public ScanDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public interface ScanDetailsAdapterListener {
        void launchScanDetailsEdit(VariableDetails variableDetails);
    }
}
