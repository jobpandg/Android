package com.lifi.jobhelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.lifi.jobhelper.domain.BaseObject;
import com.lifi.jobhelper.utils.ActivityUtil;

abstract public class BaseActivity extends AppCompatActivity {

    abstract public void initViews();
    abstract public void initDatas();
    abstract public void initListener();
    public void init(){
        initViews();
        initDatas();
        initListener();
    }

    protected  void startActivityAfterFinishThis(Intent intent) {
        startActivity(intent);
        finish();
    }
    protected void startActivityExtraObject(Class<?> clazz, BaseObject object, String tag) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.putExtra(tag, object);
        startActivity(intent);
    }

    public BaseActivity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtil.getInstance().addActivityToList(getActivity());
        init();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            getActivity().finish();
            ActivityUtil.removeActivityFromList(getActivity());
        }
        return super.onKeyDown(keyCode, event);
    }



}
