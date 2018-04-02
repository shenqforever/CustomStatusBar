package utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import com.example.sq719.mvp_android.R;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sq719 on 2018/3/5.
 * 对Intent封装 提供Activity跳转相互传参
 */

public class UiManager {
    /**
     * Activity不带数据的跳转
     *
     * @param context
     * @param cls
     */
    public static void switcher(Context context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
        //设置切换动画，从右边进入，左边退出
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
        }
    }

    /**
     * Activity带有数据跳转
     *
     * @param context
     * @param map
     * @param cls
     */
    public static void switcher(Context context, Map<String, Object> map, Class<?> cls) {
        Intent intent = new Intent();
        putExtraData(map, intent);
        context.startActivity(intent);
        if (context instanceof  Activity){
            //设置切换动画，从右边进入，左边退出
            ((Activity) context).overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
        }
    }
    /**
     * Activity带返回值的跳转
     *
     * @param context
     * @param cls
     */
    public static void switcher(Activity context,Class<?>cls,int requestCode){
        Intent intent=new Intent();
        intent.setClass(context,cls);
        context.startActivityForResult(intent,requestCode);
        //设置切换动画，从右边进入，左边退出
        context.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    /**
     * Activity带有数据并且有返回值的跳转
     *
     * @param context
     * @param map
     * @param cls
     * @param requestCode
     */
    public  static void switcher(Activity context,Map<String,Object>map,Class<?> cls,int requestCode){
        Intent intent=new Intent();
        putExtraData(map,intent);
        intent.setClass(context,cls);
        context.startActivityForResult(intent,requestCode);
        //设置切换动画，从右边进入，左边退出
        context.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    /**
     * 添加数据
     *
     * @param map
     * @param intent 对比所有数据类型
     */
    public static void putExtraData(Map<String, Object> map, Intent intent) {
        if (map != null) {
            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = map.get(key);
                if (value instanceof Integer) {
                    intent.putExtra(key, (Integer) value);
                } else if (value instanceof String) {
                    intent.putExtra(key, (String) value);
                } else if (value instanceof Double) {
                    intent.putExtra(key, (Double) value);
                } else if (value instanceof Float) {
                    intent.putExtra(key, (Float) value);
                } else if (value instanceof Long) {
                    intent.putExtra(key, (Long) value);
                } else if (value instanceof Boolean) {
                    intent.putExtra(key, (Boolean) value);
                } else if (value instanceof Object) {
                    intent.putExtra(key, (Serializable) value);
                } else if (value instanceof Object) {
                    intent.putExtra(key, (Parcelable) value);
                }
            }
        }
    }
}
