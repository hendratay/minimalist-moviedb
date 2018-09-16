package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.AccountDetailEntity
import io.reactivex.Observable

interface  AccountDataStore {

    fun getAccountDetail(): Observable<AccountDetailEntity>

}
