#FastAndroid
------
这只是一个集合了各大吊炸天开源类库的项目和demo

This is only a project which collect many open source class and a demo

------
让我们看一下到底有那些吊炸天的类库

Let's see how cool these class are

------
>* com.android.support:support-v4:22.1.1      你懂的
>* com.android.support:appcompat-v7:22.1.1    你懂的
>* com.j256.ormlite:ormlite-android:4.48      [数据库操作的][1]
>* com.squareup.okhttp:okhttp:2.4.0           [网络的][2]
>* com.github.bumptech.glide:glide:3.6.1      [图片加载的][3]
>* com.android.support:recyclerview-v7:22.1.1 你懂的
>* com.android.support:cardview-v7:22.1.1     你懂的
>* io.reactivex:rxjava:1.1.0
>* io.reactivex:rxandroid:1.0.1

----------
下面来分析一下fastandroid的好用类库

Let's analyze good class in fast android 

#BaseActivity
这是一个好用的baseActivity，用法

This is a good base class,USE

    MainActivity extends com.gx303.fastandroid.BaseActivity
    {
    @Override
    public void setContentView() {
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
    }

    
#BaseFragmentActivity
和BaseActivity同理

Same as BaseActivity

#FastAdapter
这是一个好用方便的BaseAdapter，可以用于Listview或者GridView

This is a good use BaseAdapter,Can use for ListView or GridView

            FastAdapter adapter1=new FastAdapter<String>(getApplicationContext(),datas,R.layout.xxx) {
            @Override
            public void convert(ViewHolder helper, String item) {
                //findview
                ImageView iv1=helper.getView(R.id.imageView2);
                //dosth
            }
        };
        lv1.setAdapter(adapter1);

#FastDialog
这是一个好用方便的dialog类

This is a good use dialog class

          Dialog  da1=new FastDialog(DialogDemo.this,R.style.Trans_Fullscreen,R.layout.xxx){
            @Override
            public void createDialog(ViewHolder helper) {
                TextView tv_sure=helper.getView(R.id.tv_sure);
                tv_sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        da1.dismiss();
                    }
                });
            }
        }.getDialog();

#FastRecyclerViewAdapter
这是一个好用方便的RecyclerView.Adapter

This is a good use RecyclerView.Adapter

            com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas,R.layout.xxxxxx){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                //findview
                TextView tv1=helper.getView(R.id.text_view);
                //dosth
                tv1.setText(item);
            }
        };
        rv1.setAdapter(adapter1);

#FastDatabaseHelper
这是一个好用方便的数据库类

This a good use sqlbase class

User类的写法参照[OrmLite官方][4]
User Class writing way [OrmLite官方][4]

     public class dbhelp1 extends FastDatabaseHelper{
         static  String DataBaseName="db1.db";
         static int DATABASE_VERSION=2;
         public dbhelp1(Context context)
         {
             super(context,DataBaseName,DATABASE_VERSION);
         }
         @Override
         public void setBeans() {
             super.beans.add(User.class);
         }
     }
#FastDbHelper
这个类可以和FastDatabaseHelper配合最佳，就如巧克力和下雨天最配

This Class can match FastDatabaseHelper good ,just as eat chocolate in rainy day

     FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
     fh.create(new User("hehe123123"));
#FastHttp
这个类是网络请求的
This class can use for http post or get

        Map<String,String > map1=new HashMap<String,String>();
        map1.put("key1","value1");
        map1.put("key2","value2");
        map1.put("key3","value3");
        map1.put("key4","value4");
        map1.put("key4", "测试中文");
        com.gx303.fastandroid.http.FastHttp.POST("http://weixingtest1.sinaapp.com/testpost.php", map1, new FastHttpCallback() {
            @Override
            public void onResponse(String result) {
                e("测试POST结束" + result);
            }

            @Override
            public void onFailure(String error) {

            }
        });

#FastHttpRx
这个类是用rx的方法进行网络请求
This class is use rx class to http post or get

        com.gx303.fastandroid.http.FastHttpRx.GET(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver);
        
#FastLogUtils
方便的log管理
Good log manager

     e("easy as pie");
        
#DropDownListView
可下拉刷新和上拉自动加载的ListView 

Can pull to refresh and pull up auto load listview 

    private DropDownListView listView;
    listView=(DropDownListView)findViewById(R.id.dropdownlistview);
        // set drop down listener
        listView.setOnDropDownListener(new DropDownListView.OnDropDownListener() {

            @Override
            public void onDropDown() {
                new GetDataTask(true).execute();
            }
        });
        // set on bottom listener
        listView.setOnBottomListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new GetDataTask(false).execute();
            }
        });

#PullLoadMoreRecyclerView
可下拉刷新和上拉自动加载的RecyclerView

Can pull to refresh and pull up auto load RecyclerView

    com.gx303.fastandroid.view.recyclerview.PullLoadMoreRecyclerView rv1;
    rv1=(com.gx303.fastandroid.view.recyclerview.PullLoadMoreRecyclerView)findViewById(R.id.pulltoloadview);
    rv1.setLinearLayout();
           rv1.setPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener(){
               @Override
               public void onRefresh() {
                   handler.sendEmptyMessageDelayed(1,2000);
               }

               @Override
               public void onLoadMore() {
                   handler.sendEmptyMessageDelayed(2,2000);
               }
           });
        
        Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
                super.handleMessage(msg);
                rv1.setPullLoadMoreCompleted();
            }
        };

#FastLoopViewPagerWithIncicator
可以无限循环的Viewpager,只需传入图片的链接(图片个数需要大于等于4)

A viewpager who can infinite loop and you only need input link of images(images num must biger than 3)

    com.gx303.fastandroid.view.viewpager.FastLoopViewPagerWithIncicator fastLoopViewPagerWithIncicator;

    fastLoopViewPagerWithIncicator.setImages(imagesurl, new onClickViewPagerItemListsner() {
        @Override
        public void onclick(int index) {
            Toast.makeText(viewpagertest.this, "onclick"+index, Toast.LENGTH_SHORT).show();
        }
    });

    //autoloop
    fastLoopViewPagerWithIncicator.startAutoLoop(0,2000);
    //endloop
    fastLoopViewPagerWithIncicator.endAutoLoop();

#ClearEditText
自带删除的Edittext

A Edittext with clear button

    <com.gx303.fastandroid.view.ClearEditText
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:id="@+id/view"/>

#RxBus
使用rx写的总线通知
    http://nerds.weddingpartyapp.com/tech/2014/12/24/implementing-an-event-bus-with-rxjava-rxbus/
  [1]: https://github.com/j256/ormlite-android
  [2]: https://github.com/square/okhttp
  [3]: https://github.com/bumptech/glide
  [4]: http://ormlite.com/