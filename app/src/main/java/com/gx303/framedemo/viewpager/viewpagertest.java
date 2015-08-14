package com.gx303.framedemo.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gx303.fastandroid.view.viewpager.onClickViewPagerItemListsner;
import com.gx303.framedemo.R;

import java.util.ArrayList;
import java.util.List;

import static com.gx303.fastandroid.utils.FastLogUtils.e;

/**
 * Created by Administrator on 2015/8/11.
 */
public class viewpagertest extends com.gx303.fastandroid.BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.viewpagertest_main);
    }
    com.gx303.fastandroid.view.viewpager.FastLoopViewPagerWithIncicator fastLoopViewPagerWithIncicator;
    @Override
    public void findViews() {
        fastLoopViewPagerWithIncicator=(com.gx303.fastandroid.view.viewpager.FastLoopViewPagerWithIncicator)findViewById(R.id.view2);
    }
    List<String> imagesurl;
    @Override
    public void getData() {
        imagesurl=new ArrayList<String>();
        imagesurl.add("http://pic74.nipic.com/file/20150802/12692071_135433749000_2.jpg");
        imagesurl.add("http://pic17.huitu.com/res/20140314/529068_20140314155942409106_1.jpg");
        imagesurl.add("http://pic34.huitu.com/res/20150718/757319_20150718095228561200_1.jpg");
        imagesurl.add("http://pic74.nipic.com/file/20150808/8072984_101201175842_2.jpg");
//        imagesurl.add("http://pic74.nipic.com/file/20150808/8072984_093049443152_2.jpg");
//        imagesurl.add("http://pic74.nipic.com/file/20150806/20580255_140550188000_2.jpg");
//        imagesurl.add("http://pic74.nipic.com/file/20150810/15079367_120904857000_2.jpg");
//        imagesurl.add("http://pic74.nipic.com/file/20150730/8614903_171847405000_2.jpg");
    }

    @Override
    public void showContent() {
        fastLoopViewPagerWithIncicator.setImages(imagesurl, new onClickViewPagerItemListsner() {
            @Override
            public void onclick(int index) {
                Toast.makeText(viewpagertest.this, "onclick"+index, Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void startloop(View v)
    {
        fastLoopViewPagerWithIncicator.startAutoLoop(0,2000);
    }
    public void endloop(View v)
    {
        fastLoopViewPagerWithIncicator.endAutoLoop();
    }


}
