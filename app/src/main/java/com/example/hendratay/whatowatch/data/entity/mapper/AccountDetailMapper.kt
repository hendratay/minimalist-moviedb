package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.AccountDetailEntity
import com.example.hendratay.whatowatch.data.entity.AvatarEntity
import com.example.hendratay.whatowatch.data.entity.GravatarEntity
import com.example.hendratay.whatowatch.domain.model.AccountDetail
import com.example.hendratay.whatowatch.domain.model.Avatar
import com.example.hendratay.whatowatch.domain.model.Gravatar
import javax.inject.Inject

class AccountDetailMapper @Inject constructor(private val avatarMapper: AvatarMapper): Mapper<AccountDetailEntity, AccountDetail> {

    override fun mapFromEntity(type: AccountDetailEntity): AccountDetail {
        return AccountDetail(avatarMapper.mapFromEntity(type.avatar),
                type.id,
                type.languageCode,
                type.CountryCode,
                type.name,
                type.includeAdult,
                type.username)
    }

    override fun mapToEntity(type: AccountDetail): AccountDetailEntity {
        return AccountDetailEntity(avatarMapper.mapToEntity(type.avatar),
                type.id,
                type.languageCode,
                type.CountryCode,
                type.name,
                type.includeAdult,
                type.username)
    }

}

class AvatarMapper @Inject constructor(private val gravatarMapper: GravatarMapper): Mapper<AvatarEntity, Avatar> {

    override fun mapFromEntity(type: AvatarEntity): Avatar {
        return Avatar(gravatarMapper.mapFromEntity(type.gravatar))
    }

    override fun mapToEntity(type: Avatar): AvatarEntity {
        return AvatarEntity(gravatarMapper.mapToEntity(type.gravatar))
    }

}

class GravatarMapper @Inject constructor(): Mapper<GravatarEntity, Gravatar> {

    override fun mapFromEntity(type: GravatarEntity): Gravatar {
        return Gravatar(type.hash)
    }

    override fun mapToEntity(type: Gravatar): GravatarEntity {
        return GravatarEntity(type.hash)
    }

}