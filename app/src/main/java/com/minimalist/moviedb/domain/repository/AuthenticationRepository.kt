package com.minimalist.moviedb.domain.repository

import com.minimalist.moviedb.domain.model.AuthToken
import io.reactivex.Observable

interface AuthenticationRepository {

    fun getAuthToken(): Observable<AuthToken>

}