package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.AuthTokenEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class AuthenticationCloudDataStore: AuthenticationDataStore {

    override fun getAuthToken(): Observable<AuthTokenEntity> {
        return TMDBServiceFactory.makeService().authToken()
    }

}