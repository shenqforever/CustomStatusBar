package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.StatusBarCompat;
import com.example.entity.TitleManager2;
import com.example.sq719.mvp_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private View view;
    TitleManager2 titleManager2;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        /**
         *  添加jar
         * 在项目中使用方法 更换状态栏颜色
         */
        StatusBarCompat.setColor(getActivity(), R.color.blue);//更换状态栏
        /***
         * 实际项目中可以把这个注册放到 BaseApplication类中 避免重复代码
         * 注册自定义标题 在当前布局文件引入 <include layout="@layout/activity_title" />
         */
        titleManager2 = new TitleManager2(getActivity());
        titleManager2.setTitleTxt("自定义");// 定义标题栏中间内容
        /***
         * //设置左边返回图片 返回功能已经封装好了 直接可以使用 back定义了一个空
         */
        titleManager2.setLeftLayout(R.string.back, R.drawable.re_test);
        titleManager2.setFontBackground(R.color.f4);//设置字体颜色
        titleManager2.setBackground(R.color.blue);//设置背景颜色
        titleManager2.setRightTxt(R.string.test);//设置右边字体
        return view;
    }

}
