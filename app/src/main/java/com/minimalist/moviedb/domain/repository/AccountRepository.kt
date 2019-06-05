package com.minimalist.moviedb.domain.repository

import com.minimalist.moviedb.domain.model.AccountDetail
import io.reactivex.Observable

interface AccountRepository {

    fun getAccountDetail(): Observable<AccountDetail>

}