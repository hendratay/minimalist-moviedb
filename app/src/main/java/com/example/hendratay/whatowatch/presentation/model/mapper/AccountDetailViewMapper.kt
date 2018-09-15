package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.AccountDetail
import com.example.hendratay.whatowatch.domain.model.Avatar
import com.example.hendratay.whatowatch.domain.model.Gravatar
import com.example.hendratay.whatowatch.presentation.model.AccountDetailView
import com.example.hendratay.whatowatch.presentation.model.AvatarView
import com.example.hendratay.whatowatch.presentation.model.GravatarView
import javax.inject.Inject

class AccountDetailViewMapper @Inject constructor(private val avatarViewMapper: AvatarViewMapper): Mapper<AccountDetailView, AccountDetail> {

    override fun mapToView(type: AccountDetail): AccountDetailView {
        return AccountDetailView(avatarViewMapper.mapToView(type.avatar),
                type.id,
                type.languageCode,
                type.CountryCode,
                type.name,
                type.includeAdult,
                type.username)
    }

}

class AvatarViewMapper @Inject constructor(private val gravatarViewMapper: GravatarViewMapper): Mapper<AvatarView, Avatar> {

    override fun mapToView(type: Avatar): AvatarView {
        return AvatarView(gravatarViewMapper.mapToView(type.gravatar))
    }

}

class GravatarViewMapper @Inject constructor(): Mapper<GravatarView, Gravatar> {

    override fun mapToView(type: Gravatar): GravatarView {
        return GravatarView(type.hash)
    }

}
