package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.AccountDetail
import com.example.hendratay.whatowatch.domain.repository.AccountRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAccountDetail @Inject constructor(private val accountRepository: AccountRepository): UseCase<AccountDetail, Any>() {

    override fun buildUseCaseObservable(params: Any?): Observable<AccountDetail> {
        return accountRepository.getAccountDetail()
    }

}
