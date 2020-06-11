package com.nicolas.multifunctionlibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MultiFunctionTextView extends AppCompatTextView implements TextWatcher {
    private static final String TAG = "MultiFunctionTextView";
    private Drawable mClearDrawable = null;
    private Drawable mDrawEndDrawable = null;

    public MultiFunctionTextView(Context context) {
        super(context);
        init();
    }

    public MultiFunctionTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiFunctionTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //获取右边图片
        this.mDrawEndDrawable = this.getCompoundDrawablesRelative()[2];
        Log.d(TAG, "init: mDrawEndDrawable is null-->" + (this.mDrawEndDrawable == null));
        //清空图标
        this.mClearDrawable = getResources().getDrawable(R.drawable.ic_cancel);
        //设置图标的位置以及大小,getIntrinsicWidth()获取显示出来的大小而不是原图片的带小
        this.mClearDrawable.setBounds(0, 0, this.mClearDrawable.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
        //显示图标
        setClearIconVisible(false);
        //设置使能点击
        this.setClickable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //判断是否是点击了清空图标的区域
            boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                    && (event.getX() < ((getWidth() - getPaddingRight())));
            if (touchable) {
                this.setText("");
            }
        }

        return super.onTouchEvent(event);
    }

    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     *
     * @param visible 显示与否
     */
    protected void setClearIconVisible(boolean visible) {
        if (visible) {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0],
                    getCompoundDrawables()[1], this.mClearDrawable, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0],
                    getCompoundDrawables()[1], this.mDrawEndDrawable, getCompoundDrawables()[3]);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        setClearIconVisible(s.length() > 0);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
