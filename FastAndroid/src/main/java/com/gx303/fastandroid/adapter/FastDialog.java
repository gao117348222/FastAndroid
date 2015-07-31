package com.gx303.fastandroid.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2015/7/31.
 */
public abstract class FastDialog {
    protected Dialog dialog;
    protected View dialogView;
    protected ViewHolder viewHolder;
    public FastDialog(Activity activity, int style, int dialogLayout)
    {
        dialogView=View.inflate(activity, dialogLayout, null);
        viewHolder=new ViewHolder(dialogView);
        createDialog(viewHolder);
        dialog=createDialog1(activity,dialogView,style);
    }
    public  Dialog getDialog(){
        return dialog;
    }
    public abstract void createDialog(ViewHolder helper);
    private Dialog createDialog1(Activity activity,View view,int style){
        Dialog dialog=new Dialog(activity,style);
        dialog.setContentView(view);
        Window dialogWindow =dialog.getWindow();
        WindowManager.LayoutParams dialogLayoutParams= dialogWindow.getAttributes();
        dialogLayoutParams.width=LayoutParams.MATCH_PARENT;
        dialogLayoutParams.height=LayoutParams.WRAP_CONTENT;
        dialogWindow.setGravity(Gravity.CENTER);
        dialog.setCancelable(false);
        return dialog;
    }
}
