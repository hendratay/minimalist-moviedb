package com.minimalist.moviedb.domain.interactor

import com.minimalist.moviedb.domain.model.AuthToken
import com.minimalist.moviedb.domain.repository.AuthenticationRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAuthToken @Inject constructor(private val authenticationRepository: AuthenticationRepository): UseCase<AuthToken, Any>() {

    override fun buildUseCaseObservable(params: Any?): Observable<AuthToken> {
        return authenticationRepository.getAuthToken()
    }

}