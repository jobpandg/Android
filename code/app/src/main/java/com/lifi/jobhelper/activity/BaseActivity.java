package com.lifi.jobhelper.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.lifi.jobhelper.Observer.NetStateChangeObserver;
import com.lifi.jobhelper.domain.BaseObject;
import com.lifi.jobhelper.utils.ActivityUtil;
import com.lifi.jobhelper.utils.NetUtil;

abstract public class BaseActivity extends AppCompatActivity implements NetStateChangeObserver {

    public static NetStateChangeObserver netObserver;
    private int netMobile;

    abstract public void initViews();
    abstract public void initDatas();
    abstract public void initListener();
    abstract public void init();

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
        netObserver = this;
        inspectNet();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            getActivity().finish();
            ActivityUtil.removeActivityFromList(getActivity());
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
        isNetConnect();

    }

    public boolean inspectNet() {
        this.netMobile = NetUtil.getNetWorkState(BaseActivity.this);
        return isNetConnect();
    }

    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;

        }
        return false;
    }

    /**
     * 权限检查方法，false代表没有该权限，ture代表有该权限
     */
    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    /**
     * 权限请求方法
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    /**
     * 处理请求权限结果事件
     *
     * @param requestCode  请求码
     * @param permissions  权限组
     * @param grantResults 结果集
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doRequestPermissionsResult(requestCode, grantResults);
    }

    /**
     * 处理请求权限结果事件
     *
     * @param requestCode  请求码
     * @param grantResults 结果集
     */
    public void doRequestPermissionsResult(int requestCode, @NonNull int[] grantResults) {
    }


}
