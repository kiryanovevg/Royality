package com.kiryanov.royality.data

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("/api/example/get-user")
    fun getUsers(): Observable<List<User>>

    @GET("http://40.113.122.2:10012/api/example/get-user")
    fun connect1(): Observable<List<CordaUser>>

    @GET("http://40.113.122.2:10015/api/example/get-user")
    fun connect2(): Observable<List<CordaUser>>

    @GET("http://40.113.122.2:10018/api/example/get-user")
    fun connect3(): Observable<List<CordaUser>>

    @GET("http://40.113.122.2:10021/api/example/get-user")
    fun connectCoalition(): Observable<List<CordaUser>>
}