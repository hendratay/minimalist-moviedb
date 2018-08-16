package com.example.hendratay.whatowatch.data.repository.datasource

import javax.inject.Inject

class TvDataStoreFactory @Inject constructor() {

    fun create() = TvCloudDataStore()

}