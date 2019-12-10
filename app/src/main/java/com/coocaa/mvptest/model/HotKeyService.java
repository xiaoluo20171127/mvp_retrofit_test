package com.coocaa.mvptest.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LEGION XiaoLuo
 * @description
 * @created on 2019/12/10
 */
public class HotKeyService {

    private Retrofit mRetrofit;
    private static volatile HotKeyService sService;

    private HotKeyService(){

    }

    public static HotKeyService getInstance(){
        if(sService == null){
            synchronized (HotKeyService.class){
                if(sService == null){
                    sService = new HotKeyService();
                }
            }
        }
        return sService;
    }

    public Retrofit createRetrofit(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
