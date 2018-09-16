package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.AccountDetailEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class AccountCloudDataStore: AccountDataStore {

    override fun getAccountDetail(): Observable<AccountDetailEntity> {
        return TMDBServiceFactory.makeService().accountDetail()
    }

}
