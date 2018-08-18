package com.example.hendratay.whatowatch.data.remote

import com.example.hendratay.whatowatch.data.entity.MoviePopularEntity
import com.example.hendratay.whatowatch.data.entity.TvPopularEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    fun popularMovie(@Query("page") page: Int): Observable<MoviePopularEntity>

    @GET("tv/popular")
    fun popularTv(@Query("page") page: Int): Observable<TvPopularEntity>

}