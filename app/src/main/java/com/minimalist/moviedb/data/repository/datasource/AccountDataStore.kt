package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.AccountDetailEntity
import io.reactivex.Observable

interface  AccountDataStore {

    fun getAccountDetail(): Observable<AccountDetailEntity>

}
