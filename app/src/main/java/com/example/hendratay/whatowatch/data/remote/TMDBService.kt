package com.example.hendratay.whatowatch.data.remote

import com.example.hendratay.whatowatch.data.entity.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    @GET("/authentication/token/new")
    fun authToken(): Observable<AuthTokenEntity>

    @GET("account")
    fun accountDetail(): Observable<AccountDetailEntity>

    @GET("movie/popular")
    fun moviePopular(@Query("page") page: Int): Observable<MoviePopularEntity>

    @GET("movie/{movie_id}")
    fun movieDetail(@Path("movie_id") movieId: Int): Observable<MovieDetailEntity>

    @GET("tv/popular")
    fun tvPopular(@Query("page") page: Int): Observable<TvPopularEntity>

    @GET("tv/{tv_id}")
    fun tvDetail(@Path("tv_id") tvId: Int): Observable<TvDetailEntity>

    @GET("person/popular")
    fun actorPopular(@Query("page") page: Int): Observable<ActorPopularEntity>

    @GET("person/{person_id}")
    fun actorDetail(@Path("person_id") actorId: Int): Observable<ActorDetailEntity>

}