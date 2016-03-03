package com.gx303.framedemo;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;


import com.gx303.fastandroid.db.FastDbHelper;
import com.gx303.fastandroid.http.FastHttpCallback;
import com.gx303.framedemo.cardview.cardviewtest;
import com.gx303.framedemo.cardview.recycler_fresh;
import com.gx303.framedemo.dialog.DialogDemo;
import com.gx303.framedemo.image.ImageActivity;
import com.gx303.framedemo.listviewdemo.LvActivity;
import com.gx303.framedemo.orm.User;
import com.gx303.framedemo.orm.dbhelp1;
import com.gx303.framedemo.orm.ormtest;
import com.gx303.framedemo.pulllistview.LoadMoreActivity;
import com.gx303.framedemo.recyelcviewdemo.testRecycleView;
import com.gx303.framedemo.view.viewtest;
import com.gx303.framedemo.viewpager.viewpagertest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.gx303.fastandroid.utils.FastLogUtils.e;


public class MainActivity extends com.gx303.fastandroid.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        e("aaaaaaaaaaaaaaaaaaaaa");

        com.gx303.fastandroid.utils.PreferencesUtils.putString(getApplication(), "ceshi", "测试");
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void showContent() {

    }

    public void insertsql(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
        fh.create(new User("呵呵呵123123"));

    }
    public void selectSql(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
        List<User> l1=fh.queryForAll(User.class);
        for(int i=0;i<l1.size();i++)
        {
            e("user:"+l1.get(i).getName());
        }

    }
    public void updatesql(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));

    }
    public void openlistview(View v)
    {
        Intent it_lv=new Intent();
        it_lv.setClass(getApplicationContext(), LvActivity.class);
        startActivity(it_lv);
    }

    /**
     * @param v 下拉刷新
     *          用到第三方 in.srain.cube:ultra-ptr
     */
    public void openpulllistview(View v)
    {
        Intent it_pull=new Intent();
        it_pull.setClass(getApplicationContext(),com.gx303.framedemo.pulllistview.PullRefreshActivity.class);
//        it_pull.setClass(getApplicationContext(), LvActivity.class);
        startActivity(it_pull);
    }

    /**
     * @param v 下拉刷新和自动更多
     */
    public void openloadmore(View v)
    {
        Intent it_loadmore=new Intent();
        it_loadmore.setClass(getApplicationContext(), LoadMoreActivity.class);
        startActivity(it_loadmore);
    }
    public void openfragment(View v)
    {
        Intent it_fra=new Intent();
        it_fra.setClass(getApplicationContext(), testFragmentActivity.class);
        startActivity(it_fra);
    }

    /**
     * @param v 获取相册图片
     */
    public void getxc(View v)
    {
//        Uri u1=Uri.parse("/mnt/sdcard/screenshot.png");
//        e("aaaaa"+u1.toString());


        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1111&&resultCode==RESULT_OK)
        {
            Uri fileUri = data.getData();
            e("aaaaa"+fileUri.toString());
            e("aaaaa"+ fileUri.getPath());
            e("aaaaa"+changeUriToPath(fileUri));
        }
    }
    // 将URI转换为真实路径
    private String changeUriToPath(Uri uri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor actualImageCursor = managedQuery(uri, proj, null, null, null);
        int actual_image_column_index = actualImageCursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        actualImageCursor.moveToFirst();
        String currentImagePath = actualImageCursor
                .getString(actual_image_column_index);
        return currentImagePath;
    }

    /**
     * @param v 访问网络测试 get
     */
    public void webtest(View v)
    {
        e("访问网络开始");
//        com.gx303.fastandroid.http.FastHttp.GET("http://www.weather.com.cn/adat/sk/101110101.html", new FastHttpCallback() {
//            @Override
//            public void onResponse(String result) {
//                e("访问网络测试结果"+result);
//            }
//
//            @Override
//            public void onFailure(String error) {
//
//            }
//        });
//        Map<String,String> map1=new HashMap<>();
//        map1.put("username","15860756273");
//        map1.put("password","123456");
//        com.gx303.fastandroid.http.FastHttp.POST("http://www.fyh0597.com/api/user/login", map1, new FastHttpCallback() {
//            @Override
//            public void onResponse(String result) {
//                e("访问网络测试结果"+result);
//            }
//
//            @Override
//            public void onFailure(String error) {
//                e("失败");
//            }
//        });

    }
    public void testpost(View v)
    {
        e("测试POST开始");
        Map<String,String > map1=new HashMap<String,String>();
        map1.put("key1","value1");
        map1.put("key2","value2");
        map1.put("key3","value3");
        map1.put("key4","value4");
        map1.put("key4", "测试中文");



        com.gx303.fastandroid.http.FastHttp.POST("http://weixingtest1.sinaapp.com/testpost.php",map1, new FastHttpCallback() {
            @Override
            public void onResponse(String result) {
                e("测试POST结束" + result);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
    public void testglide(View v)
    {
        Intent itimage=new Intent();
        itimage.setClass(getApplicationContext(), ImageActivity.class);
        startActivity(itimage);
    }
    public void createdialog(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(), DialogDemo.class);
        startActivity(it1);
    }
    public void testrecyclerview(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),testRecycleView.class);
        startActivity(it1);
    }
    public void testsql(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),ormtest.class);
        startActivity(it1);
    }
    public void testcardview(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),cardviewtest.class);
        startActivity(it1);
    }
    public void testview(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),viewtest.class);
        startActivity(it1);
    }
    public void testrecycler(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),recycler_fresh.class);
        startActivity(it1);
    }
    public void testviewpager(View v)
    {
        Intent it1=new Intent();
        it1.setClass(getApplicationContext(),viewpagertest.class);
        startActivity(it1);
    }
    /*
    测试rxandroid
     */
    public void rxandroidtest(View v)
    {
//        myObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(mySubscriber);
//        com.gx303.fastandroid.http.FastHttpRx.GET("http://cmbox.cmswat.com/cmbox/plugin/getPluginList.php")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        e("获取到网络数据"+s);
//                    }
//                });
        com.gx303.fastandroid.http.FastHttpRx.GET("http://cmbox.cmswat.com/cmbox/plugin/getPluginList.php")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver);
//                .subscribe(mySubscriber);

        /*
        测试post
         */
//        Map<String,String > map1=new HashMap<String,String>();
//        map1.put("key1","value1");
//        map1.put("key2","value2");
//        map1.put("key3","value3");
//        map1.put("key4","value4");
//        map1.put("key4", "测试中文");
//        com.gx303.fastandroid.http.FastHttpRx.POST("http://weixingtest1.sinaapp.com/testpost.php",map1)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(mySubscriber);
    }

    Observer<String> myObserver=new Observer<String>() {
        @Override
        public void onCompleted() {
            e("onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            e("onError"+e);
        }

        @Override
        public void onNext(String s) {
            e("获取到网络数据" + s);
        }
    };
    Subscriber<String> mySubscriber=new Subscriber<String>() {
        @Override
        public void onStart() {
            e("onStart");
        }

    @Override
        public void onCompleted() {
            e("onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            e("onError"+e);
        }

        @Override
        public void onNext(String s) {
            e("获取到网络数据" + s);
//            t(s);
        }
    };

}
