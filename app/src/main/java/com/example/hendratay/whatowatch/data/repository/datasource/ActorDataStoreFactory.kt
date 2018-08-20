package com.example.hendratay.whatowatch.data.repository.datasource

import javax.inject.Inject


class ActorDataStoreFactory @Inject constructor() {

    fun create() = ActorCloudDataStore()

}
