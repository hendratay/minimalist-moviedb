package com.example.hendratay.whatowatch.data.repository.datasource

import javax.inject.Inject

class MovieDataStoreFactory @Inject constructor() {

    fun create() = MovieCloudDataStore()

}