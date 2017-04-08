package com.mtdev.ringscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;

import com.mtdev.ringscrollview.view.BottomHorizontalScrollView;
import com.mtdev.ringscrollview.view.TopHorizontalScrollView;


public class MainActivity extends AppCompatActivity implements ScrollViewListener {

    private TopHorizontalScrollView mTopHSV;
    private BottomHorizontalScrollView mBottomHSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] heros = {R.mipmap.hero_chengjisihan, R.mipmap.hero_daqiao, R.mipmap.hero_donghuangtaiyi, R.mipmap.hero_huangzhong, R.mipmap.hero_neza, R.mipmap.hero_taiyizhenren, R.mipmap.hero_yangjian, R.mipmap.hero_zhugeliang};
        mTopHSV = (TopHorizontalScrollView) findViewById(R.id.id_top);
        mBottomHSV = (BottomHorizontalScrollView) findViewById(R.id.id_bottom);

        mTopHSV.addImageViewFromRes(heros);
        mBottomHSV.addImageViewFromRes(heros);

        mTopHSV.setScrollViewListener(this);
        mBottomHSV.setScrollViewListener(this);
    }

    @Override
    public void onScrollStateChanged(HorizontalScrollView view, int scrollState, int index) {

    }

    @Override
    public void onScrollChanged(HorizontalScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == mTopHSV) {
            mBottomHSV.scrollBy(oldx - x, y);
        }

       /* if (scrollView == mBottomHSV) {
            mTopHSV.scrollBy(oldx - x, y);
        }*/
    }
}
