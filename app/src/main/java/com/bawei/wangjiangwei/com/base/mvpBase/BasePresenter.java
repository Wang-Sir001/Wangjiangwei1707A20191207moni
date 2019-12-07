package com.bawei.wangjiangwei.com.base.mvpBase;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {

    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {

        model = initModel();

    }

    public void attachView(V v){
        weakReference = new WeakReference<>(v);
    }

    protected abstract M initModel();

    public void detach(){
        if (weakReference != null){
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView(){
        return weakReference.get();
    }
}
