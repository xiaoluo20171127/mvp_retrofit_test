package com.coocaa.mvptest.presenter;

import com.coocaa.mvptest.model.DataModel;
import com.coocaa.mvptest.model.HotKey;
import com.coocaa.mvptest.model.IDataModel;
import com.coocaa.mvptest.view.IDataView;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public class DataPresenter implements IDataPresenter {
    private IDataView mDataView;
    private DataModel mDataModel;
    public HotKey mHotKey;

    public DataPresenter(IDataView dataView) {
        mDataView = dataView;
        mDataModel = new DataModel();
    }

    @Override
    public void download() {
        mDataView.download();
        mDataModel.setCallback(new DataModel.DataCallback() {
            @Override
            public void backHotKeyData(HotKey hotKey) {
                mHotKey = hotKey;
                downloadSuccess(null);
            }
        });
        mDataModel.downloadData();
    }

    @Override
    public void downloadSuccess(Object data) {
        mDataView.downloadSuccess();
    }

    @Override
    public void downloadFail(String msg) {

    }

    @Override
    public void showData() {
        if(mHotKey != null) {
            mDataView.showData(mHotKey);
        }else{
            mDataView.showData(null);
        }
    }
}
