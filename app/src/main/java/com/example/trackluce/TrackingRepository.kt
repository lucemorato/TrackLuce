package com.example.trackluce

import androidx.annotation.WorkerThread

class TrackingRepository(private val trackingDao: TrackingDao) {

    val allTrackingEntities = trackingDao.getAllTrackingEntities()
    val lastTrackingEntity = trackingDao.getLastTrackingEntity()
    val totalDistanceTravelled = trackingDao.getTotalDistanceTravelled()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllTrackingEntitiesRecord() = trackingDao.getAllTrackingEntitiesRecord()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getLastTrackingEntityRecord() = trackingDao.getLastTrackingEntityRecord()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(trackingEntity: TrackingEntity) {
        trackingDao.insert(trackingEntity)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        trackingDao.deleteAll()
    }
}