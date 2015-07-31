package com.gx303.framedemo.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

import com.gx303.fastandroid.adapter.FastDialog;
import com.gx303.fastandroid.adapter.ViewHolder;
import com.gx303.framedemo.R;

/**
 * Created by Administrator on 2015/7/31.
 */
public class DialogDemo extends com.gx303.fastandroid.BaseActivity
{
    Dialog da1;
    @Override
    public void setContentView() {
        setContentView(R.layout.dialogtest);
    }

    @Override
    public void findViews() {


        da1=new FastDialog(DialogDemo.this,R.style.Trans_Fullscreen,R.layout.dialog_notice_view){
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
    }

    @Override
    public void getData() {

    }

    @Override
    public void showContent() {

    }
    public void createDialog(View v)
    {
        if(da1.isShowing())
        {
            da1.dismiss();
        }
        else
        {
            da1.show();
        }
    }
}
