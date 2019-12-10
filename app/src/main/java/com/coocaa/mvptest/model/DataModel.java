package com.coocaa.mvptest.model;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public class DataModel implements IDataModel {
    DataCallback mCallback;

    public DataModel() {

    }

    public interface DataCallback {
        void backHotKeyData(HotKey hotKey);
    }

    public void setCallback(DataCallback dataCallback){
        mCallback = dataCallback;
    }

    @Override
    public void downloadData() {
        Retrofit retrofit = HotKeyService.getInstance().createRetrofit();
        final HotKeyRequestInterface request = retrofit.create(HotKeyRequestInterface.class);
        Call<HotKey> call = request.getHotKetData();
        call.enqueue(new Callback<HotKey>() {
            @Override
            public void onResponse(Call<HotKey> call, Response<HotKey> response) {
                HotKey hotKey = response.body();
                if(mCallback != null){
                    mCallback.backHotKeyData(hotKey);
                }
            }

            @Override
            public void onFailure(Call<HotKey> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}
