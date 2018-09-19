package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.AuthTokenEntity
import com.example.hendratay.whatowatch.domain.model.AuthToken
import javax.inject.Inject

class AuthTokenMapper @Inject constructor(): Mapper<AuthTokenEntity, AuthToken> {

    override fun mapFromEntity(type: AuthTokenEntity): AuthToken {
        return AuthToken(type.success, type.expiresAt, type.requestToken)
    }

    override fun mapToEntity(type: AuthToken): AuthTokenEntity {
        return AuthTokenEntity(type.success, type.expiresAt, type.requestToken)
    }

}