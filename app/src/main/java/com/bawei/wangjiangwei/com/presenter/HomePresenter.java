package com.bawei.wangjiangwei.com.presenter;

import com.bawei.wangjiangwei.com.base.mvpBase.BasePresenter;
import com.bawei.wangjiangwei.com.contract.IHomeContract;
import com.bawei.wangjiangwei.com.model.HomeModel;
import com.bawei.wangjiangwei.com.model.entity.HomeEntity;

public class HomePresenter extends BasePresenter<HomeModel,IHomeContract.IView> implements IHomeContract.IPresenter{

    @Override
    public void getHome() {
        model.getHome(new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(HomeEntity homeEntity) {
                getView().success(homeEntity);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }
}
