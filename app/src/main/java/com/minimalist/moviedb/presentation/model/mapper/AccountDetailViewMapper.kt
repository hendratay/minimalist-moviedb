package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.AccountDetail
import com.minimalist.moviedb.domain.model.Avatar
import com.minimalist.moviedb.domain.model.Gravatar
import com.minimalist.moviedb.presentation.model.AccountDetailView
import com.minimalist.moviedb.presentation.model.AvatarView
import com.minimalist.moviedb.presentation.model.GravatarView
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
