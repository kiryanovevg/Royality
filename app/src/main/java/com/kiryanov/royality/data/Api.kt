package com.kiryanov.royality.data

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("/api/example/get-user")
    fun getUsers(): Observable<List<User>>

    @GET("http://51.145.142.95:10012/api/example/get-user")
    fun connect1(): Observable<List<CordaUser>>

    @GET("http://51.145.142.95:10015/api/example/get-user")
    fun connect2(): Observable<List<CordaUser>>

    @GET("http://51.145.142.95:10018/api/example/get-user")
    fun connect3(): Observable<List<CordaUser>>
}