package com.minimalist.moviedb.data.repository.datasource

import javax.inject.Inject


class ActorDataStoreFactory @Inject constructor() {

    fun create() = ActorCloudDataStore()

}
