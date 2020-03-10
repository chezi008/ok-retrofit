package com.chezi008.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitManager.init("http://gank.io/ ")

        btnHttp.setOnClickListener {
            RetrofitManager.retrofit.create(RetorfitApi::class.java)
                    .getGankIOData("福利", 3, 1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer {
                        Log.d(TAG, "获取数据:${it.results}")
                    }, Consumer {

                    })
        }
    }
}
