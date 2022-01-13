package com.example.snplugin.testmodule;

import android.app.Application;

import com.ahca.sts.STShield;

public class App extends Application {
    static App app;
    String mobileUserId;


    public App() {
    }

    public App(String mobileUserId) {
        this.mobileUserId = mobileUserId;
    }

    public static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        System.out.println("开始初始化。。。");
//        stShield
//                .init(this, "http://117.71.58.71:66/sjd", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
//                .initThemeColor(this, getResources().getColor(R.color.stsColorPrimary))
//                .initUseId(this, mobileUserId);
    }
}
