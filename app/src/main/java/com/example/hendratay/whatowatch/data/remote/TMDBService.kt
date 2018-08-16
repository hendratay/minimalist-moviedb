package com.example.hendratay.whatowatch.data.remote

import com.example.hendratay.whatowatch.data.entity.PopularMovieEntity
import com.example.hendratay.whatowatch.data.entity.PopularTvEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    fun popularMovie(@Query("page") page: Int): Observable<PopularMovieEntity>

    @GET("tv/popular")
    fun popularTv(@Query("page") page: Int): Observable<PopularTvEntity>

}