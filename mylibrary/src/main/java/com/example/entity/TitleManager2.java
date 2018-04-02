package com.example.entity;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mylibrary.R;

/**
 * Created by sq719 on 2018/3/21.
 *
 */

public class TitleManager2 {
    private Activity ac;
    private View view;
    Resources rs;
    public TitleManager2(Activity ac){
        this.ac = ac;
        rs = ac.getResources();
    }
    public TitleManager2(View view){
        this.view = view;
        rs = view.getResources();
    }

    public interface RightLayoutListener{
        public void rightOnListener();
    }

    public interface LeftLayoutListener{
        public void rightOnListener();
    }
    public void setLeftLayout(int leftTxtId, int leftImgId){

        ImageView mLeftImg;
        TextView mLeftTxt;
        LinearLayout layout = null;
        if(ac == null){
            mLeftImg = (ImageView) view.findViewById(R.id.left_img);
            mLeftTxt = (TextView) view.findViewById(R.id.left_txt);

        }else{
            layout = (LinearLayout)ac.findViewById(R.id.left_layout);
            mLeftImg = (ImageView) ac.findViewById(R.id.left_img);
            mLeftTxt = (TextView) ac.findViewById(R.id.left_txt);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ac.overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
                    ac.finish();
                }
            });
        }

        layout.setVisibility(View.VISIBLE);
        if(leftTxtId>0){
            mLeftTxt.setText(rs.getString(leftTxtId));
        }
        if(leftImgId>0){
            mLeftImg.setImageResource(leftImgId);
        }


    }
    public void setLeftLayoutListener(final LeftLayoutListener listener){

        LinearLayout layout = null;
        if(ac == null){

        }else{
            layout = (LinearLayout)ac.findViewById(R.id.left_layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ac.overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
                    ac.finish();
                }
            });
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });


    }
    /**
     * 设置标题栏标题文本
     * @param rId
     */
    public void setTitleTxt(int rId){
        TextView mTitleTxt = null;
        if(ac == null){
            mTitleTxt = (TextView) view.findViewById(R.id.title_txt);
        }else{
            mTitleTxt = (TextView) ac.findViewById(R.id.title_txt);
        }
        mTitleTxt.setText(rs.getString(rId));
    }

    /**
     * 设置标题栏标题文本
     * @param txt
     */
    public void setTitleTxt(String txt){
        TextView mTitleTxt = null;
        if(ac == null){
            mTitleTxt = (TextView) view.findViewById(R.id.title_txt);
        }else{
            mTitleTxt = (TextView) ac.findViewById(R.id.title_txt);
        }
        mTitleTxt.setText(txt);
    }

    /**
     * 设置右侧图片文字
     */
    public void setRightLayout(int rightTxtId,int rightImgId,final RightLayoutListener listener){

        LinearLayout layout = null;
        TextView rightTxt = null;
        ImageView rightImg = null;
        if(ac == null){
            rightImg = (ImageView) view.findViewById(R.id.right_img);
            rightTxt = (TextView) view.findViewById(R.id.right_txt);
            layout = (LinearLayout)view.findViewById(R.id.right_layout);
        }else{
            layout = (LinearLayout)ac.findViewById(R.id.right_layout);
            rightImg = (ImageView) ac.findViewById(R.id.right_img);
            rightTxt = (TextView) ac.findViewById(R.id.right_txt);
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });

        if(rightTxtId>0){
            rightTxt.setText(rs.getString(rightTxtId));
        }
        if(rightImgId>0){
            rightImg.setVisibility(View.VISIBLE);
            rightImg.setBackgroundResource(rightImgId);
        }else{
            rightImg.setVisibility(View.GONE);
        }

    }


    /**
     * 设置标题栏左边图标
     * @param rId
     */
    public void setLeftImg(int rId){
        ImageView mLeftImg = null;
        if(ac == null){
            mLeftImg = (ImageView) view.findViewById(R.id.left_img);
        }else{
            mLeftImg = (ImageView) ac.findViewById(R.id.left_img);
        }
        mLeftImg.setImageResource(rId);
    }
    /**
     * 设置标题栏左边文本
     * @param rId
     */
    public void setLeftTxt(int rId){
        TextView mLeftTxt = null;
        if(ac == null){
            mLeftTxt = (TextView) view.findViewById(R.id.left_txt);
        }else{
            mLeftTxt = (TextView) ac.findViewById(R.id.left_txt);
        }

        mLeftTxt.setText(rs.getString(rId));
    }

    /**
     * 设置标题栏右边图标
     * @param rId
     */
    public void setRightImg(int rId){
        ImageView mRightImg = null;
        if(ac == null){
            mRightImg = (ImageView) view.findViewById(R.id.right_img);
        }else{
            mRightImg = (ImageView) ac.findViewById(R.id.right_img);
        }
        mRightImg.setImageResource(rId);
    }
    /**
     * 设置标题栏右边文本
     * @param rId
     */
    public void setRightTxt(int rId){
        TextView mRightTxt = null;
        if(ac == null){
            mRightTxt = (TextView) view.findViewById(R.id.right_txt);
        }else{
            mRightTxt = (TextView) ac.findViewById(R.id.right_txt);
        }
        mRightTxt.setText(rs.getString(rId));
    }

    //设置背景颜色
    public void setBackground(int drawable) {
        RelativeLayout relativeLayout = null;
        if (ac == null) {
            relativeLayout = (RelativeLayout) view.findViewById(R.id.re_layout);

        } else {
            relativeLayout = (RelativeLayout) ac.findViewById(R.id.re_layout);
        }
        relativeLayout.setBackgroundResource(drawable);
    }
    //设置标题字体背景
    public  void setFontBackground(int id){
        TextView mTitleTxt = null;
        if(ac == null){
            mTitleTxt = (TextView) view.findViewById(R.id.title_txt);
        }else{
            mTitleTxt = (TextView) ac.findViewById(R.id.title_txt);
        }
        mTitleTxt.setTextColor(rs.getInteger(id));
    }

    //设置右边字体背景
    public  void setRightFontBackground(int id){
        TextView mTitleTxt = null;
        if(ac == null){
            mTitleTxt = (TextView) view.findViewById(R.id.right_txt);
        }else{
            mTitleTxt = (TextView) ac.findViewById(R.id.right_txt);
        }
        mTitleTxt.setTextColor(rs.getInteger(id));
    }
    /**
     * 设置标题栏点击右布局响应事件
     * @param listener
     */
    public void setRightLayoutListener(final RightLayoutListener listener){
        LinearLayout layout = null;
        if(ac == null){
            layout = (LinearLayout)view.findViewById(R.id.right_layout);
        }else{
            layout = (LinearLayout)ac.findViewById(R.id.right_layout);
        }

        layout.setVisibility(View.VISIBLE);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightOnListener();
            }
        });
    }
}
