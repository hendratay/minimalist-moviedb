package com.minimalist.moviedb.domain.interactor

import com.minimalist.moviedb.domain.model.AccountDetail
import com.minimalist.moviedb.domain.repository.AccountRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAccountDetail @Inject constructor(private val accountRepository: AccountRepository): UseCase<AccountDetail, Any>() {

    override fun buildUseCaseObservable(params: Any?): Observable<AccountDetail> {
        return accountRepository.getAccountDetail()
    }

}
