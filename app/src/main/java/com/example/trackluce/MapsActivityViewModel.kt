package com.example.trackluce


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MapsActivityViewModel(private val trackingRepository: TrackingRepository): ViewModel() {


    val allTrackingEntities: LiveData<List<TrackingEntity>> = trackingRepository.allTrackingEntities
    val allTrackingEntitiesRecord: MutableLiveData<List<TrackingEntity>> = MutableLiveData(listOf())
    val lastTrackingEntity: LiveData<TrackingEntity?> = trackingRepository.lastTrackingEntity
    val totalDistanceTravelled: LiveData<Float?> = trackingRepository.totalDistanceTravelled
    val currentNumberOfStepCount = MutableLiveData(0)
    var initialStepCount = 0


    fun getAllTrackingEntities() = viewModelScope.launch {
        allTrackingEntitiesRecord.value =  trackingRepository.getAllTrackingEntitiesRecord()
    }


    fun insert(trackingEntity: TrackingEntity) = viewModelScope.launch {
        trackingRepository.getLastTrackingEntityRecord()?.let {
            trackingEntity.distanceTravelled = trackingEntity.distanceTo(it)
        }
        trackingRepository.insert(trackingEntity)
    }

    fun deleteAllTrackingEntity() = viewModelScope.launch {
        currentNumberOfStepCount.value = 0
        initialStepCount = 0
        trackingRepository.deleteAll()
    }
}