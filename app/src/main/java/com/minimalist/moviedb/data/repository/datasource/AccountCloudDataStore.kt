package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.AccountDetailEntity
import com.minimalist.moviedb.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class AccountCloudDataStore: AccountDataStore {

    override fun getAccountDetail(): Observable<AccountDetailEntity> {
        return TMDBServiceFactory.makeService().accountDetail()
    }

}
