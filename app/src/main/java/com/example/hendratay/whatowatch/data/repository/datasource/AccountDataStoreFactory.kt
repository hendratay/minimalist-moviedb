package com.example.hendratay.whatowatch.data.repository.datasource

import javax.inject.Inject

class AccountDataStoreFactory @Inject constructor() {

    fun create() = AccountCloudDataStore()

}