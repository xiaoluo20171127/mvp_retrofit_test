package com.coocaa.mvptest.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public interface HotKeyRequestInterface {
    @GET("hotkey/json")
    Call<HotKey> getHotKetData();
}
