package com.example.hendratay.whatowatch.data.repository.datasource

import javax.inject.Inject

class AuthenticationDataStoreFactory @Inject constructor() {

    fun create() = AuthenticationCloudDataStore()

}