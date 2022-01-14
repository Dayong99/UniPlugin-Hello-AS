package com.example.snplugin.testmodule;

import android.app.Activity;

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
    private STShield stShield;

    private STShield getStShieldInstance(String mobileUserId) {
        if (this.stShield == null) {
            this.stShield = STShield.INSTANCE.init(this.mUniSDKInstance.getContext(), "http://117.71.58.71:66/", "8C987B3ABE59BB2BDA8727951C5A9342", "22611BFDB4C4E114874A0C9A4D24AA34")
                    .initThemeColor(this.mUniSDKInstance.getContext(), this.mUniSDKInstance.getContext().getResources().getColor(R.color.stsColorPrimary))
                    .initUseId(this.mUniSDKInstance.getContext(), mobileUserId);
        }
        return this.stShield;
    }

    /**
     * 获取本地证书
     */
    @UniJSMethod
    public void getLocalCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));

        STShield stShield = getStShieldInstance(mobileUserId);

        if (!stShield.isLocalCertExist(this.mUniSDKInstance.getContext())) {
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", 500);
                    put("result", "未发现本地证书");
                }
            });
        }

        stShield.getCert((Activity) this.mUniSDKInstance.getContext(), STShield.CERT_TYPE_SIGNCERT, getCertResult -> {
            System.out.println(getCertResult.getEnCert());
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", 200);
                    put("cert", getCertResult);
                }
            });
            return null;
        });
    }


    /**
     * 获取企业证书
     */
    @UniJSMethod
    public void applyCompanyCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield stShield = getStShieldInstance(mobileUserId);

        StsCompanyInfo stsCompanyInfo = new StsCompanyInfo();
        stsCompanyInfo.setCompanyName("杭州品茗信息技术有限公司");
        stsCompanyInfo.setCompanyNo("91330108699830971L");
        stsCompanyInfo.setCardNum("420111197009154095");
        stsCompanyInfo.setDepartmentNo("91330108699830971L");
        stsCompanyInfo.setPhoneNum("15515556655");
        stsCompanyInfo.setUserEmail("2484030571@qq.com");
        stsCompanyInfo.setUserName("莫绪军");

        stShield.applyCompanyCert((Activity) this.mUniSDKInstance.getContext(), stsCompanyInfo, applyCertResult -> {
            System.out.println(applyCertResult);
            jsCallback.invoke(new JSONObject() {
                {
                    put("code", "200");
                    put("msg", applyCertResult);
                }
            });
            return null;
        });


    }

    /**
     * 获取个人证书
     */
    @UniJSMethod
    public void applyPersonalCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield stShield = getStShieldInstance(mobileUserId);

        StsUserInfo stsUserInfo = new StsUserInfo();
        stsUserInfo.setUserName("铁柱妈妈");
        stsUserInfo.setCardNum("632323190605261984");
        stsUserInfo.setCardType(STShield.CARD_TYPE_ID_CARD);
        stsUserInfo.setPhoneNum("13324445543");
        stsUserInfo.setUserEmail("1234@qq.com");
        stsUserInfo.setUserCity("铁岭1");
        stShield.applyPersonalCert((Activity) this.mUniSDKInstance.getContext(), stsUserInfo, applyCertResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("applyCertResult", applyCertResult);
                }
            });
            return null;
        });
    }

    /**
     * 检查证书状态
     */
    @UniJSMethod
    public void checkCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield stShield = getStShieldInstance(mobileUserId);
        stShield.checkCert((Activity) this.mUniSDKInstance.getContext(), commonResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("commonResult", commonResult);
                }
            });
            return null;
        });
    }

    /**
     * 更新个人证书
     */
    @UniJSMethod
    public void updatePersonalCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield stShield = getStShieldInstance(mobileUserId);
        StsUserInfo stsUserInfo = JSONObject.parseObject(String.valueOf(jsonObject), StsUserInfo.class);
        stShield.updatePersonalCert((Activity) this.mUniSDKInstance.getContext(), stsUserInfo, commonResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("commonResult", commonResult);
                }
            });
            return null;
        });
    }

    /**
     * 更新企业证书
     */
    @UniJSMethod
    public void updateCompanyCert(JSONObject jsonObject, UniJSCallback jsCallback) {
        String mobileUserId = String.valueOf(jsonObject.get("mobileUserId"));
        STShield stShield = getStShieldInstance(mobileUserId);
        StsCompanyInfo stsCompanyInfo = JSONObject.parseObject(String.valueOf(jsonObject), StsCompanyInfo.class);
        stShield.updateCompanyCert((Activity) this.mUniSDKInstance.getContext(), stsCompanyInfo, commonResult -> {
            jsCallback.invoke(new JSONObject() {
                {
                    put("commonResult", commonResult);
                }
            });
            return null;
        });
    }
}
