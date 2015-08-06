package com.gx303.framedemo.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.gx303.fastandroid.adapter.FastAdapter;
import com.gx303.fastandroid.adapter.ViewHolder;
import com.gx303.framedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/30.
 */
public class LvActivity extends Activity {
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewtest);
        lv1=(ListView)findViewById(R.id.listView);


//        SparseArray<String> aa =new SparseArray<>();
//        aa.append(1,"111");
//



        List<String> mDatas=new ArrayList<>();
        mDatas.add("1");
        mDatas.add("2");
        mDatas.add("3");
        mDatas.add("4");
        mDatas.add("5");
        mDatas.add("6");
        mDatas.add("7");
        mDatas.add("8");
        mDatas.add("9");

        FastAdapter adapter1=new FastAdapter<String>(getApplicationContext(),mDatas,R.layout.lv_item1) {
            @Override
            public void convert(ViewHolder helper, String item) {
                Log.e("Unity", "convert");
                TextView tv1=helper.getView(R.id.textView);
                tv1.setText(item);
                Button bt1=helper.getView(R.id.button2);
                bt1.setText(item);
                bt1.setTag(item);
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("com.gx303.framedemo",""+v.getTag());
                    }
                });
            }
        };
        lv1.setAdapter(adapter1);

    }
    public boolean containKey(SparseArray sparseArray,int key)
    {
        Object value=sparseArray.get(key,123456);
        if(value==123456)
        {
            return false;
        }
        else
        {
            return  true;
        }

    }
}
