package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.AuthTokenEntity
import com.minimalist.moviedb.domain.model.AuthToken
import javax.inject.Inject

class AuthTokenMapper @Inject constructor(): Mapper<AuthTokenEntity, AuthToken> {

    override fun mapFromEntity(type: AuthTokenEntity): AuthToken {
        return AuthToken(type.success, type.expiresAt, type.requestToken)
    }

    override fun mapToEntity(type: AuthToken): AuthTokenEntity {
        return AuthTokenEntity(type.success, type.expiresAt, type.requestToken)
    }

}