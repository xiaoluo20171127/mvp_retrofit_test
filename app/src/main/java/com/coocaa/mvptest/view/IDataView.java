package com.coocaa.mvptest.view;

import com.coocaa.mvptest.model.HotKey;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public interface IDataView {
    void download();

    void downloadSuccess();

    void downloadFail(String msg);

    void showData(HotKey hotKey);
}
