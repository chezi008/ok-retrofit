package com.chezi008.retrofit;

import android.util.Log;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author ：chezi008 on 2018/4/11 16:22
 * @description ：
 * @email ：chezi008@163.com
 */
public class OkHttpUtil {
    /**
     * 设置缓存目录
     */
    private final File cacheDirectory = new File("", "httpCache");

    private Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);


    public OkHttpClient getClient() {
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
}
