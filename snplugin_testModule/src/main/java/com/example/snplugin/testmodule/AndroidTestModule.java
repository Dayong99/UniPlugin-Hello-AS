package com.example.snplugin.testmodule;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ahca.sts.STShield;
import com.ahca.sts.models.StsCompanyInfo;
import com.ahca.sts.models.StsUserInfo;
import com.alibaba.fastjson.JSONObject;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniModule;

// Module 扩展必须继承 UniModule 类(父类)
// 扩展方法必须加上@UniJSMethod (uiThread = false or true) 注解。UniApp 会根据注解来判断当前方法是否要运行在 UI 线程，和当前方法是否是扩展方法。
// UniApp是根据反射来进行调用 Module 扩展方法，所以Module中的扩展方法必须是 public 类型。
// 离线打包AppKey为daf8f60bd6b80efb3577713821dfd774
//测试地址和授权
//http://117.71.58.71:66/sjd
//测试app_key:8C987B3ABE59BB2BDA8727951C5A9342
//测试secret_key:22611BFDB4C4E114874A0C9A4D24AA34
public class AndroidTestModule extends UniModule {
    private static SharedPreferences dsp;

    private static SharedPreferences getCacheManager() {
        if (dsp == null) {
            dsp = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        }
        return dsp;
    }

    @UniJSMethod
    public void add(JSONObject json, UniJSCallback jsCallback) {
        jsCallback.invoke(new JSONObject(){
            {
                put("1", "1");
            }
        });
//        String mobileUserId = String.valueOf(json.get("mobileUserId"));
//
//        STShield.INSTANCE
//                .init(this.mUniSDKInstance.getContext(), "http://117.71.58.71:66/", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
//                .initThemeColor(this.mUniSDKInstance.getContext(), this.mUniSDKInstance.getContext().getResources().getColor(R.color.stsColorPrimary))
//                .initUseId(this.mUniSDKInstance.getContext(), mobileUserId);
//
//        STShield.INSTANCE.getDepartmentNo((Activity) this.mUniSDKInstance.getContext(), getDepartmentNoResult -> {
//            System.out.println(getDepartmentNoResult);
//            jsCallback.invoke(new JSONObject() {
//                {
//                    put("getDepartmentNoResult", getDepartmentNoResult);
//                }
//            });
//            return null;
//        });

    }

    @UniJSMethod
    public void getLocalCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));

        STShield.INSTANCE
                .init(this.mUniSDKInstance.getContext(), "http://117.71.58.71:66/", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
                .initThemeColor(this.mUniSDKInstance.getContext(), this.mUniSDKInstance.getContext().getResources().getColor(R.color.stsColorPrimary))
                .initUseId(this.mUniSDKInstance.getContext(), mobileUserId);

        if (!STShield.INSTANCE.isLocalCertExist(this.mUniSDKInstance.getContext())) {
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", 500);
                    put("result", "未发现本地证书");
                }
            });
        }

        STShield.INSTANCE.getCert((Activity) this.mUniSDKInstance.getContext(), STShield.CERT_TYPE_SIGNCERT, getCertResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", 200);
                    put("cert", getCertResult);
                }
            });
            return null;
        });

    }


    @UniJSMethod
    public void applyCompanyCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield.INSTANCE
                .init(this.mUniSDKInstance.getContext(), "http://117.71.58.71:66/", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
                .initThemeColor(this.mUniSDKInstance.getContext(), this.mUniSDKInstance.getContext().getResources().getColor(R.color.stsColorPrimary))
                .initUseId(this.mUniSDKInstance.getContext(), mobileUserId);

//        StsCompanyInfo stsCompanyInfo1 = new StsCompanyInfo();
//        stsCompanyInfo1.setCompanyName("企业名称");
//        stsCompanyInfo1.setCardNum("110101199003077096");
//        stsCompanyInfo1.setCompanyNo("12330100470100604B");
//        stsCompanyInfo1.setDepartmentNo("123");
//        stsCompanyInfo1.setPhoneNum("18815556655");
//        stsCompanyInfo1.setUserEmail("123@qq.com");
//        stsCompanyInfo1.setUserName("张三");
//        STShield.INSTANCE.applyCompanyCert((Activity) this.mUniSDKInstance.getContext(), stsCompanyInfo1, applyCertResult -> {
//            StsCompanyInfo stsCompanyInfo = applyCertResult.getStsCompanyInfo();
//            System.out.println(applyCertResult.getResultMsg());
//            jsCallback.invoke(new JSONObject() {
//                {
//                    put("code", "200");
//                    put("msg", applyCertResult.getResultMsg());
//                }
//            });
//            return null;
//        });

        StsUserInfo stsUserInfo = new StsUserInfo();
        stsUserInfo.setUserName("铁柱妈妈");
        stsUserInfo.setCardNum("632323190605261984");
        stsUserInfo.setCardType(STShield.CARD_TYPE_ID_CARD);
        stsUserInfo.setPhoneNum("13324445543");
        stsUserInfo.setUserEmail("1234@qq.com");
        stsUserInfo.setUserCity("铁岭1");
        STShield.INSTANCE.applyPersonalCert((Activity) this.mUniSDKInstance.getContext(), stsUserInfo, applyCertResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("applyCertResult", applyCertResult);
                }
            });
            return null;

        });
    }

    @UniJSMethod
    public void onCreate(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield.INSTANCE
                .init(this.mUniSDKInstance.getContext(), "http://117.71.58.71:66/", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
                .initThemeColor(this.mUniSDKInstance.getContext(), this.mUniSDKInstance.getContext().getResources().getColor(R.color.stsColorPrimary))
                .initUseId(this.mUniSDKInstance.getContext(), mobileUserId);

//        StsCompanyInfo stsCompanyInfo1 = new StsCompanyInfo();
//        stsCompanyInfo1.setCompanyName("杭州品茗信息技术有限公司");
//        stsCompanyInfo1.setCardNum("420111197009154095");
//        stsCompanyInfo1.setCompanyNo("91330108699830971L");
//        stsCompanyInfo1.setDepartmentNo("123");
//        stsCompanyInfo1.setPhoneNum("15515556655");
//        stsCompanyInfo1.setUserEmail("2484030571@qq.com");
//        stsCompanyInfo1.setUserName("莫绪军");
//        STShield.INSTANCE.applyCompanyCert((Activity) this.mUniSDKInstance.getContext(), stsCompanyInfo1, applyCertResult -> {
//            StsCompanyInfo stsCompanyInfo = applyCertResult.getStsCompanyInfo();
//            System.out.println(applyCertResult.getResultMsg());
//            jsCallback.invoke(new JSONObject() {
//                {
//                    put("code", "200");
//                    put("msg", applyCertResult.getResultMsg());
//                }
//            });
//            return null;
//        });

        StsUserInfo stsUserInfo = new StsUserInfo();
        stsUserInfo.setUserName("铁柱妈妈");
        stsUserInfo.setCardNum("632323190605261984");
        stsUserInfo.setCardType(STShield.CARD_TYPE_ID_CARD);
        stsUserInfo.setPhoneNum("13324445543");
        stsUserInfo.setUserEmail("1234@qq.com");
        stsUserInfo.setUserCity("铁岭1");
        STShield.INSTANCE.applyPersonalCert((Activity) this.mUniSDKInstance.getContext(), stsUserInfo, applyCertResult -> {
            System.out.println(applyCertResult.getResultMsg());
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", "200");
                    put("applyCertResult", applyCertResult);
                    put("msg", applyCertResult.getResultMsg());
                }
            });
            return null;

        });

    }
}
