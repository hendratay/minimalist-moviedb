package com.minimalist.moviedb.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.AuthTokenMapper
import com.minimalist.moviedb.data.repository.datasource.AuthenticationDataStoreFactory
import com.minimalist.moviedb.domain.model.AuthToken
import com.minimalist.moviedb.domain.repository.AuthenticationRepository
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