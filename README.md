# ok-retrofit
安卓网络框架，okhttp3+Retrofit2+RxJava2

[![](https://jitpack.io/v/chezi008/ok-retrofit.svg)](https://jitpack.io/#chezi008/ok-retrofit)

#### 1、引入依赖

```
dependencies {
	        implementation 'com.github.chezi008:ok-retrofit:1.x.x'
	}
```

#### 2、在Application里面进行初始化操作

```
RetrofitManager.init("http://gank.io/ ")
```

#### 3、新建api类

```
interface RetorfitApi{

    @GET("api/data/{type}/{count}/{page}")
    fun getGankIOData(@Path("type") type: String,
                      @Path("count") count: Int,
                      @Path("page") page: Int):Observable<HttpResp>

}
```

#### 4、http请求

```
RetrofitManager.retrofit.create(RetorfitApi::class.java)
                .getGankIOData("福利",3,1)
                .subscribeOn(Schedulers.io())
                .subscribe(Consumer {
                    Log.d(TAG,"获取数据:${it.results}")
                }, Consumer {

                })
```

