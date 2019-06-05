package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.AuthTokenEntity
import io.reactivex.Observable

interface AuthenticationDataStore {

    fun getAuthToken(): Observable<AuthTokenEntity>

}