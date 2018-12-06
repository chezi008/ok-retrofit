package com.chezi008.retrofit;

import android.util.Log;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author ：chezi008 on 2018/12/6 10:23
 * @description ：
 * @email ：chezi008@163.com
 */
public class RetrofitClient implements IRetrofit{
    /**
     * 设置缓存目录
     */
    private final File cacheDirectory = new File("", "httpCache");

    private Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
    @Override
    public OkHttpClient initOkhttp() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .cookieJar(CookieJar.NO_COOKIES)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("http", message);
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .build();
        return mOkHttpClient;
    }

    @Override
    public Retrofit initRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initOkhttp())
                .build();
        return retrofit;
    }
}
