package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.AuthTokenMapper
import com.example.hendratay.whatowatch.data.repository.datasource.AuthenticationDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.AuthToken
import com.example.hendratay.whatowatch.domain.repository.AuthenticationRepository
import io.reactivex.Observable
import javax.inject.Inject

class AuthenticationDataRepository @Inject constructor(private val factory: AuthenticationDataStoreFactory,
                                                       private val authTokenMapper: AuthTokenMapper):
        AuthenticationRepository {

    override fun getAuthToken(): Observable<AuthToken> {
        return factory.create().getAuthToken()
                .map { authTokenMapper.mapFromEntity(it) }
    }

}