package com.coocaa.mvptest.presenter;

import android.widget.TextView;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public interface IDataPresenter<T> {
    void download();

    void downloadSuccess(T data);

    void downloadFail(String msg);

    void showData();
}
