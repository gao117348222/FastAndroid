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
//    com.gx303.fastandroid.view.viewpager.FastLoopViewPager viewPager;
//    com.gx303.fastandroid.view.viewpager.PageIndicator  mPageIndicator;
    com.gx303.fastandroid.view.viewpager.FastLoopViewPagerWithIncicator fastLoopViewPagerWithIncicator;
    @Override
    public void findViews() {
//        viewPager=(com.gx303.fastandroid.view.viewpager.FastLoopViewPager)findViewById(R.id.viewpager);
//        mPageIndicator=(com.gx303.fastandroid.view.viewpager.PageIndicator)findViewById(R.id.indicator);
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
        imagesurl.add("http://pic74.nipic.com/file/20150808/8072984_093049443152_2.jpg");
        imagesurl.add("http://pic74.nipic.com/file/20150806/20580255_140550188000_2.jpg");
        imagesurl.add("http://pic74.nipic.com/file/20150810/15079367_120904857000_2.jpg");
        imagesurl.add("http://pic74.nipic.com/file/20150730/8614903_171847405000_2.jpg");
    }

    @Override
    public void showContent() {
        fastLoopViewPagerWithIncicator.setImages(imagesurl, new onClickViewPagerItemListsner() {
            @Override
            public void onclick(int index) {
                Toast.makeText(viewpagertest.this, "onclick"+index, Toast.LENGTH_SHORT).show();
            }
        });
//        final List<View> list1=new ArrayList<>();
//        for(int i=0;i<imagesurl.size();i++)
//        {
//            ImageView iv1=new ImageView(getApplicationContext());
//            Glide.with(getApplicationContext())
//                    .load(imagesurl.get(i))
//                    .into(iv1);
//            list1.add(iv1);
//        }
//        viewPager.setImages(imagesurl);
//        mPageIndicator.setViewPager(viewPager);
//        MyViewPagerAdapter1 adapter1=new MyViewPagerAdapter1(list1);
//        viewPager.setAdapter(adapter1);
//        viewPager.setCurrentItem(list1.size()*2000);
//        viewPager.setCurrentItem(1);
//        e("aaa"+adapter1.getCount());
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                if(i==0)
//                {
//                    viewPager.setCurrentItem(list1.size()+1);
//                }
//                if(i==(list1.size()+1))
//                {
//                    viewPager.setCurrentItem(1);
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//        e("aa" + (Integer.MAX_VALUE + Integer.MAX_VALUE % list1.size()) / 2);
//        viewPager.setCurrentItem((Integer.MAX_VALUE+Integer.MAX_VALUE%list1.size())/2);

    }
    public void startloop(View v)
    {
        fastLoopViewPagerWithIncicator.startAutoLoop(0,2000);
    }
    public void endloop(View v)
    {
        fastLoopViewPagerWithIncicator.endAutoLoop();
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));//删除页卡
            e("destroyItem"+position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//这个方法用来实例化页卡
            e("instantiateItem"+position);
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }
    public class MyViewPagerAdapter1 extends PagerAdapter {
        private List<View> mListViews;
        private int MAX_INT=Integer.MAX_VALUE;
        public MyViewPagerAdapter1(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position % mListViews.size()));//删除页卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//这个方法用来实例化页卡
            container.addView(mListViews.get(position % mListViews.size()), 0);//添加页卡
            return mListViews.get(position%mListViews.size());
        }

        @Override
        public int getCount() {
            return  MAX_INT;//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

    }
    public class MyViewPagerAdapter2 extends PagerAdapter {
        private List<View> mListViews;
        public MyViewPagerAdapter2(List<View> mListViews) {
//            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
            this.mListViews=new ArrayList<>();
            this.mListViews.add(mListViews.get(mListViews.size()-1));
            for(int i=0;i<mListViews.size();i++)
            {
                this.mListViews.add(mListViews.get(i));
            }
            this.mListViews.add(mListViews.get(0));
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));//删除页卡
            e("destroyItem" + position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//这个方法用来实例化页卡
            e("instantiateItem"+position);
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }


    public class MyViewPagerAdapter3 extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter3(List<String> mImageUrls) {
//            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
            mListViews=new ArrayList<>();
            mListViews.add(getImageView(mImageUrls.get(mImageUrls.size()-1)));
            for(int i=0;i<mImageUrls.size();i++)
            {
                mListViews.add(getImageView(mImageUrls.get(i)));
            }
            mListViews.add(getImageView(mImageUrls.get(0)));
        }
        private ImageView getImageView(String url)
        {
            ImageView iv1=new ImageView(getApplicationContext());
            Glide.with(getApplicationContext())
                    .load(url)
                    .into(iv1);
            return iv1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));//删除页卡
            e("destroyItem"+position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//这个方法用来实例化页卡
            e("instantiateItem"+position);
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }
}
