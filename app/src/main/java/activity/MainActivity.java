package activity;

import android.app.Activity;

import android.os.Bundle;

import com.example.StatusBarCompat;
import com.example.entity.TitleManager2;
import com.example.sq719.mvp_android.R;

import utils.T;


public class MainActivity extends Activity {

    TitleManager2 titleManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /**
         *  添加jar
         * 在项目中使用方法 更换状态栏颜色
         */
        StatusBarCompat.setColor(this, R.color.white);//更换状态栏
        /***
         * 实际项目中可以把这个注册放到 BaseApplication类中 避免重复代码
         * 注册自定义标题 在当前布局文件引入
         */
        titleManager2 = new TitleManager2(this);
        titleManager2.setTitleTxt("自定义");// 定义标题栏中间内容
        /***
         * //设置左边返回图片 返回功能已经封装好了 直接可以使用 back定义了一个空
         */
        titleManager2.setLeftLayout(R.string.back, R.drawable.re_test);
        titleManager2.setFontBackground(R.color.f4);//设置字体颜色
        titleManager2.setBackground(R.color.blue);//设置背景颜色
        titleManager2.setRightTxt(R.string.test);//设置右边字体
        /***
         * 设置右边点击事件监听
         */
        titleManager2.setRightLayoutListener(new TitleManager2.RightLayoutListener() {
            @Override
            public void rightOnListener() {
                /***
                 * 这个是我自己封装的toast 用系统弹框测试
                 */
                 T.show(getApplication(),"消息",3);
            }
        });
    }


}
