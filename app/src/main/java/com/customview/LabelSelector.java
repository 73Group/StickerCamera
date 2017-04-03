package com.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.skykai.stickercamera.R;


/**
 * @author tongqian.ni
 *
 */
public class LabelSelector extends LinearLayout {

    private TextView txtLabelBtn;
    private TextView addrLabelBtn;
    private TextView recordLabelBtn;

    public LabelSelector(Context context) {
        this(context,null);
    }

    public LabelSelector(Context context, AttributeSet attr) {
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.view_label_layout, this);
        txtLabelBtn = (TextView) findViewById(R.id.tv_tag_tip);
        addrLabelBtn = (TextView) findViewById(R.id.tv_tag_address);
        recordLabelBtn = (TextView) findViewById(R.id.tv_tag_record);
    }

    public void setTxtClicked(OnClickListener listener) {
        txtLabelBtn.setOnClickListener(listener);
    }

    public void setAddrClicked(OnClickListener listener) {
        addrLabelBtn.setOnClickListener(listener);
    }

    public void setRecordClicked(OnClickListener listener) {
        recordLabelBtn.setOnClickListener(listener);
    }


    public float getLastTouchX() {
        return mLastTouchX;
    }

    public float getLastTouchY() {
        return mLastTouchY;
    }

    private float mLastTouchX = -1;
    private float mLastTouchY = -1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:// 手指离开时 
            case MotionEvent.ACTION_CANCEL:
                mLastTouchX = event.getX();
                mLastTouchY = event.getY();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void showToTop() {
        setVisibility(View.VISIBLE);
        bringToFront();
    }

    public void hide() {
        setVisibility(View.GONE);
    }

}
