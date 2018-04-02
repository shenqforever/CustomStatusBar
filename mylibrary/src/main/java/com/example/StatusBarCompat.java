package com.example;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.mylibrary.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sq719 on 2018/3/21.
 * 封装状态栏以及标题统一
 * 适配4.4以上 sdk19-sdk21
 */

public class StatusBarCompat {

    /**
     * 设置状态栏颜色
     *
     * @param ac
     * @param color
     */
    public static void setColor(Activity ac, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置透明状态栏
            ac.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ac.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //android 6.0 提供的api 如果布局为白色 更换状态栏字体颜色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //设置状态栏文字颜色及图标为深色
                ac.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            try {
                //自定义颜色
                ac.getWindow().setStatusBarColor(ac.getResources().getColor(color));
            } catch (Exception e) {
                e.printStackTrace();
                //系统颜色
                ac.getWindow().setStatusBarColor(color);
            }

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            ac.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusView = null;
            try {
                // 生成一个状态栏大小的矩形
                statusView = createStatusBarView(ac, ac.getResources().getColor(color));
            } catch (Exception e) {
                e.printStackTrace();
                // 生成一个状态栏大小的矩形
                statusView = createStatusBarView(ac, color);
            }

            // 添加 statusView 到布局中
            ViewGroup decorView = (ViewGroup) ac.getWindow().getDecorView();
            decorView.addView(statusView);
            setRootView(ac);
        }
    }

    /**
     * 生成一个和状态栏大小相同的彩色矩形条
     *
     * @param ac
     * @param color
     * @return
     */
    private static View createStatusBarView(Activity ac, int color) {
        View statusBarView = new View(ac);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(ac));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        return statusBarView;
    }

    /**
     * 设置根布局参数
     *
     * @param ac
     */
    private static void setRootView(Activity ac) {
        ViewGroup rootView = (ViewGroup) ((ViewGroup) ac.findViewById(Window.ID_ANDROID_CONTENT)).getChildAt(0);
        if (rootView != null) {
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
            ac.getWindow().getDecorView().setSystemUiVisibility(rootView.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


}
