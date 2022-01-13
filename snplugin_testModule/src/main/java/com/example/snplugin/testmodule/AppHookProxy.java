package com.example.snplugin.testmodule;

import android.app.Application;

import com.ahca.sts.STShield;

import io.dcloud.feature.uniapp.UniAppHookProxy;

public class AppHookProxy  implements UniAppHookProxy {
    @Override
    public void onSubProcessCreate(Application application) {
//        STShield.INSTANCE.initServerURL(this., "http://117.71.58.71:66/sjd");

    }

    @Override
    public void onCreate(Application application) {

    }
}
