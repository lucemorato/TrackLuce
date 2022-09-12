
package com.example.trackluce

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trackluce.MapsActivityViewModel
import com.example.trackluce.TrackingRepository

class MapsActivityViewModelFactory(private val trackingRepository: TrackingRepository):
    ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {

    if (modelClass.isAssignableFrom(MapsActivityViewModel::class.java)) {
      @Suppress("UNCHECKED_CAST")
      return MapsActivityViewModel(trackingRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}