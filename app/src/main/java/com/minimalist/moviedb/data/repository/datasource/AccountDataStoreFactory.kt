package com.minimalist.moviedb.data.repository.datasource

import javax.inject.Inject

class AccountDataStoreFactory @Inject constructor() {

    fun create() = AccountCloudDataStore()

}