package com.chezi008.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author ：chezi008 on 2018/12/6 10:22
 * @description ：
 * @email ：chezi008@163.com
 */
public interface IRetrofit {

    OkHttpClient initOkhttp();

    /**
     *
     * @param baseUrl
     * @return
     */
    Retrofit initRetrofit(String baseUrl);
}
