package com.example.trackluce

import android.app.Application


class TrackingApplication: Application() {

    val trackingDatabase by lazy { TrackingDatabase.getDatabase(this) }
    val trackingRepository by lazy { TrackingRepository(trackingDatabase.getTrackingDao()) }
}