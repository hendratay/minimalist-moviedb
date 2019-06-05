package com.minimalist.moviedb.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.AccountDetailMapper
import com.minimalist.moviedb.data.repository.datasource.AccountDataStoreFactory
import com.minimalist.moviedb.domain.model.AccountDetail
import com.minimalist.moviedb.domain.repository.AccountRepository
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
