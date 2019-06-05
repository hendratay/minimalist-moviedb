package com.minimalist.moviedb.data.repository.datasource

import javax.inject.Inject

class AuthenticationDataStoreFactory @Inject constructor() {

    fun create() = AuthenticationCloudDataStore()

}