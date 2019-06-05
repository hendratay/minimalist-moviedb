package com.minimalist.moviedb.data.repository.datasource

import javax.inject.Inject

class TvDataStoreFactory @Inject constructor() {

    fun create() = TvCloudDataStore()

}