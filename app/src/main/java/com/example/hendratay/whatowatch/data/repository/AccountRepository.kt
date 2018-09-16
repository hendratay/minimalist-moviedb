package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.AccountDetailMapper
import com.example.hendratay.whatowatch.data.repository.datasource.AccountDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.AccountDetail
import com.example.hendratay.whatowatch.domain.repository.AccountRepository
import io.reactivex.Observable
import javax.inject.Inject

class AccountRepository @Inject constructor(private val factory: AccountDataStoreFactory,
                                            private val accountDetailMapper: AccountDetailMapper):
        AccountRepository {

    override fun getAccountDetail(): Observable<AccountDetail> {
        return factory.create().getAccountDetail()
                .map { accountDetailMapper.mapFromEntity(it) }
    }

}
