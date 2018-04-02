package utils;

import android.util.Log;

/**
 * Created by sq719 on 2018/3/5.
 * Log统一管理类
 */

public class L {
    /**
     * 是否需要打印Log 默认输出（除了release模式）
     */
    public static boolean IS_DEBUG;

    private static final String TAG = L.class.getSimpleName();

    // 下面四个是默认tag的函数
    public static void i(String mag) {
        if (IS_DEBUG) {
            Log.i(TAG, mag);
        }
    }

    public static void d(String mag) {
        if (IS_DEBUG) {
            Log.d(TAG, mag);
        }
    }

    public static void e(String tag, String mag) {
        if (IS_DEBUG) {
            Log.e(TAG, mag);
        }
    }

    public static void v(String mag) {
        if (IS_DEBUG) {
            Log.v(TAG, mag);
        }
    }

    // 下面是传入类名打印log
    public static void i(Class<?> _class, String mag) {
        if (IS_DEBUG) {
            Log.i(_class.getName(), mag);
        }
    }

    public static void d(Class<?> _class, String mag) {
        if (IS_DEBUG) {
            Log.d(_class.getName(), mag);
        }
    }

    public static void e(Class<?> _class, String mag) {
        if (IS_DEBUG) {
            Log.d(_class.getName(), mag);
        }
    }

    public static void v(Class<?> _class, String mag) {
        if (IS_DEBUG) {
            Log.v(_class.getName(), mag);
        }
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String mag) {
        if (IS_DEBUG) {
            Log.i(tag, mag);
        }
    }

    public static void d(String tag, String mag) {
        if (IS_DEBUG) {
            Log.d(tag, mag);
        }
    }

    public static void v(String tag, String mag) {
        if (IS_DEBUG) {
            Log.v(tag, mag);
        }
    }
}
