package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.AuthTokenEntity
import com.minimalist.moviedb.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class AuthenticationCloudDataStore: AuthenticationDataStore {

    override fun getAuthToken(): Observable<AuthTokenEntity> {
        return TMDBServiceFactory.makeService().authToken()
    }

}