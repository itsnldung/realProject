package de.dung.realproject;

import android.os.SystemClock;
import android.view.View;

public abstract class CustomClickListener implements View.OnClickListener{
    final private long DELTA_DOUBLE_CLICK_TIME = 300;
    private long lastClickTime = 0;

    public abstract void OnDoubleClick(View v);
    public abstract void OnSingleClick(View v);
    @Override
    public void onClick(View v){
        long secondClickTime = SystemClock.elapsedRealtime();
        if(secondClickTime - lastClickTime < DELTA_DOUBLE_CLICK_TIME){
            OnDoubleClick(v);
        }else{
            OnSingleClick(v);
        }
        lastClickTime = secondClickTime;
    }
}
