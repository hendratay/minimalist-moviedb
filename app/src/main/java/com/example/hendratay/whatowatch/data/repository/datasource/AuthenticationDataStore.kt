package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.AuthTokenEntity
import io.reactivex.Observable

interface AuthenticationDataStore {

    fun getAuthToken(): Observable<AuthTokenEntity>

}