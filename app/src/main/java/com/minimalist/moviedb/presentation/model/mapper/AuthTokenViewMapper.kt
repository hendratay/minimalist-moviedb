package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.AuthToken
import com.minimalist.moviedb.presentation.model.AuthTokenView
import javax.inject.Inject

class AuthTokenViewMapper @Inject constructor(): Mapper<AuthTokenView, AuthToken> {

    override fun mapToView(type: AuthToken): AuthTokenView {
        return AuthTokenView(type.success, type.expiresAt, type.requestToken)
    }

}
