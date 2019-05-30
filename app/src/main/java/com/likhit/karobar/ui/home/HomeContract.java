package com.likhit.karobar.ui.home;

import com.likhit.karobar.base.BaseView;
import com.likhit.karobar.data.models.Scan;

import java.util.List;

public interface HomeContract {

    interface Preseneter {
        void getScanList();
    }

    interface View extends BaseView{
        void OnScanListReceived(List<Scan> scanList);
    }

}
