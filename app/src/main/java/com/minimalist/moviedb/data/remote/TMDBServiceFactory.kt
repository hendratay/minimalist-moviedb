package com.minimalist.moviedb.data.remote

import com.minimalist.moviedb.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object TMDBServiceFactory {

    fun makeService(): TMDBService {
        return makeTMDBService(makeOkkHttpClient(TMDBInterceptor()), makeGson())
    }

    private fun makeTMDBService(okHttpClient: OkHttpClient, gson: Gson): TMDBService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(TMDBService::class.java)
    }

    private fun makeOkkHttpClient(tmdbInterceptor: TMDBInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(tmdbInterceptor)
                .build()
    }

    private fun makeGson() = GsonBuilder().create()

}

class TMDBInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url().newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
        return chain.proceed(chain.request().newBuilder().addHeader("Accept", "application/json").url(url).build())
    }

}