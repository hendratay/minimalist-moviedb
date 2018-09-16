package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.AccountDetail
import io.reactivex.Observable

interface AccountRepository {

    fun getAccountDetail(): Observable<AccountDetail>

}