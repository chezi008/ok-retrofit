package com.chezi008.retrofitdemo.bean

/**
 * @description ：
 * @author ：chezi008 on 2018/12/6 10:47
 * @email ：chezi008@163.com
 */
data class HttpResp(
    val error: Boolean,
    val results: List<Result>
)

data class Result(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
)