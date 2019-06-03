package com.likhit.karobar.ui.scanDetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.likhit.karobar.R;
import com.likhit.karobar.base.BaseActivity;
import com.likhit.karobar.data.models.Scan;
import com.likhit.karobar.data.models.VariableDetails;
import com.likhit.karobar.databinding.ActivityScanDetailsBinding;
import com.likhit.karobar.utils.AppConstants;

public class ScanDetailsActivity extends BaseActivity implements ScanDetailsAdapter.ScanDetailsAdapterListener {
    private ActivityScanDetailsBinding binding;

    private Scan scanItem;

    private ScanDetailsEditFragment scanDetailsEditFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_details);

        setupToolbar("Karobar", true);

        if (getIntent().getExtras() != null) {
            scanItem = (Scan) getIntent().getSerializableExtra(AppConstants.BUNDLE_KEY_SCAN_ACTIVITY);
        }

        replaceFragment(ScanDetailsViewFragment.newInstance(scanItem), ScanDetailsViewFragment.TAG, false);

    }


    @Override
    public void launchScanDetailsEdit(VariableDetails variableDetails) {
        scanDetailsEditFragment = ScanDetailsEditFragment.newInstance(variableDetails);
        replaceFragment(scanDetailsEditFragment, ScanDetailsEditFragment.TAG, true);
    }
}
