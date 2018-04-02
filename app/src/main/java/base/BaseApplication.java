package base;


import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by sq719 on 2018/3/5.
 *
 */

public class BaseApplication extends Application {
    /**
     * Log or request TAG
     */
    public static final String TAG = "RxRetrofitPatterns";
    //是否必须登录才可以访问
    public static final boolean NECESSARY_LOGINED = false;

    //创建application对象
    public static  BaseApplication mInstance;
    //Activity栈保存打开的activity，退出时关闭所有的activity
    private List<Activity> mList=new LinkedList<>();
//    // 手势解锁工具类
//    private LockPatternUtils mLockPatternUtils;
    //UserId根据userId获取用户信息
    private String userId;
    //账号信息
//    private MemberInfo accountInfo;
    //保存activity
    private Activity activity;

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
