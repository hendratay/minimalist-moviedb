package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.AuthToken
import io.reactivex.Observable

interface AuthenticationRepository {

    fun getAuthToken(): Observable<AuthToken>

}