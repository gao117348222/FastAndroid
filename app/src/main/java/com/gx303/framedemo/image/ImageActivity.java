package com.gx303.framedemo.image;

import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.gx303.fastandroid.adapter.FastAdapter;
import com.gx303.fastandroid.adapter.ViewHolder;
import com.gx303.framedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/30.
 */
public class ImageActivity extends com.gx303.fastandroid.BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.imagetest);
    }
    ListView lv1;
    @Override
    public void findViews() {
        lv1=(ListView)findViewById(R.id.listView2);
    }

    List<String> imagesurl;
    @Override
    public void getData() {
        imagesurl=new ArrayList<String>();
        imagesurl.add("http://b.hiphotos.baidu.com/image/w%3D310/sign=5b3e7bc519d5ad6eaaf962ebb1cb39a3/b64543a98226cffc9732ffb3bb014a90f603ea93.jpg");
        imagesurl.add("http://a.hiphotos.baidu.com/image/w%3D310/sign=8056a5cfb9a1cd1105b674218913c8b0/ac4bd11373f082022225d0c048fbfbedaa641b9d.jpg");
        imagesurl.add("http://e.hiphotos.baidu.com/image/w%3D310/sign=ce17a7bc6e224f4a5799751239f59044/c75c10385343fbf2cefd77b9b37eca8064388f53.jpg");
        imagesurl.add("http://h.hiphotos.baidu.com/image/w%3D310/sign=b647043c4dc2d562f208d6ecd71090f3/bd3eb13533fa828ba96137bfff1f4134970a5a2f.jpg");
        imagesurl.add("http://c.hiphotos.baidu.com/image/pic/item/6c224f4a20a44623cb9ae7929a22720e0df3d7ea.jpg");
        imagesurl.add("http://c.hiphotos.baidu.com/image/w%3D310/sign=1bfba2b7b251f819f125054beab64a76/279759ee3d6d55fb901252ba6f224f4a21a4dd51.jpg");
    }

    @Override
    public void showContent() {
        FastAdapter adapter1=new FastAdapter<String>(getApplicationContext(),imagesurl,R.layout.imagetestlistviewitem) {
            @Override
            public void convert(ViewHolder helper, String item) {
                ImageView iv1=helper.getView(R.id.imageView2);
                Glide.with(getApplicationContext())
                        .load(item)
                        .into(iv1);
            }
        };
        lv1.setAdapter(adapter1);
    }
}
