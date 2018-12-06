package com.chezi008.retrofitdemo

import com.chezi008.retrofitdemo.bean.HttpResp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @description ：
 * @author ：chezi008 on 2018/12/6 10:48
 * @email ：chezi008@163.com
 */
interface RetorfitApi{

    @GET("api/data/{type}/{count}/{page}")
    fun getGankIOData(@Path("type") type: String,
                      @Path("count") count: Int,
                      @Path("page") page: Int):Observable<HttpResp>


}