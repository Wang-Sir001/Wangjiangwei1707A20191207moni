package com.bawei.wangjiangwei.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.bawei.wangjiangwei.com.base.BaseActivity;
import com.bawei.wangjiangwei.com.base.mvpBase.BasePresenter;
import com.bawei.wangjiangwei.com.contract.IHomeContract;
import com.bawei.wangjiangwei.com.model.entity.HomeEntity;
import com.bawei.wangjiangwei.com.presenter.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(HomeEntity homeEntity) {
        if (homeEntity != null){
            Toast.makeText(this, homeEntity.getResult().getMlss().getName(), Toast.LENGTH_SHORT).show();

        }else {}
    }

    @Override
    public void error(Throwable throwable) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
