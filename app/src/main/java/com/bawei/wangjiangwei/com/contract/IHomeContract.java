package com.bawei.wangjiangwei.com.contract;

import com.bawei.wangjiangwei.com.base.mvpBase.IBaseModel;
import com.bawei.wangjiangwei.com.base.mvpBase.IBaseView;
import com.bawei.wangjiangwei.com.model.entity.HomeEntity;

public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getHome(ModelCallback modelCallback);

        interface ModelCallback{
            void success(HomeEntity homeEntity);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(HomeEntity homeEntity);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getHome();
    }
}
