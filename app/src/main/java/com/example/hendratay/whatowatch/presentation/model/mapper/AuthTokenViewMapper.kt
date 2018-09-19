package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.AuthToken
import com.example.hendratay.whatowatch.presentation.model.AuthTokenView
import javax.inject.Inject

class AuthTokenViewMapper @Inject constructor(): Mapper<AuthTokenView, AuthToken> {

    override fun mapToView(type: AuthToken): AuthTokenView {
        return AuthTokenView(type.success, type.expiresAt, type.requestToken)
    }

}
