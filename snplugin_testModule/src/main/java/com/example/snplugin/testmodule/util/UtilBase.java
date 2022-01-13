package com.example.snplugin.testmodule.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilBase {

    public static final String appKey = "ED5975F6DCDA01444746711824BC55D5";
    public static final String secretKey = "29BA47FBD25138C9B0ADFD2E61BEEACC";
    public static final String stsURL = "http://117.71.58.71:66/";

    public static final int certTypePersonal = 1;
    public static final int certTypeCompany = 2;
    public static final int certTypeVH = 3;

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static String removeBlankSpace(String string) {
        return string.replace(" ", "");
    }

    public static boolean isPhone(String mobiles) {
        Pattern p = Pattern.compile("^(1[3|4|5|7|8][0-9])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 15位和18位身份证号码的基本数字和位数验校
     */
    public static boolean isIdcard(String idcard) {
        return idcard != null && Pattern.matches(
                "(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard);
    }

    public static String TAG = "TAG";

    public static void logI(String msg) {
        Log.i(TAG, msg);
    }

    public static void logW(String msg) {
        Log.e(TAG, msg);
    }

}
