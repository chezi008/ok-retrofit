package com.chezi008.retrofitdemo

import com.chezi008.retrofit.IRetrofit
import com.chezi008.retrofit.RetrofitClient
import retrofit2.Retrofit

/**
 * @description ：
 * @author ：chezi008 on 2018/12/6 10:39
 * @email ：chezi008@163.com
 */
object RetrofitManager{
    private val retrofitClient = RetrofitClient()
    lateinit var retrofit:Retrofit

    fun init(baseUrl:String){
        retrofitClient.initOkhttp()
        retrofit = retrofitClient.initRetrofit(baseUrl)
    }


}