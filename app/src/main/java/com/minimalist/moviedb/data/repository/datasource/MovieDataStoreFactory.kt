package com.minimalist.moviedb.data.repository.datasource

import javax.inject.Inject

class MovieDataStoreFactory @Inject constructor() {

    fun create() = MovieCloudDataStore()

}