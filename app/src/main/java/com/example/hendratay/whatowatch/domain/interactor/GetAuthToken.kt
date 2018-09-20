package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.AuthToken
import com.example.hendratay.whatowatch.domain.repository.AuthenticationRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAuthToken @Inject constructor(private val authenticationRepository: AuthenticationRepository): UseCase<AuthToken, Any>() {

    override fun buildUseCaseObservable(params: Any?): Observable<AuthToken> {
        return authenticationRepository.getAuthToken()
    }

}