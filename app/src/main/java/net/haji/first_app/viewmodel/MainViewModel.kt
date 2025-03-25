package net.haji.first_app.viewmodel

import androidx.lifecycle.LiveData
import net.haji.first_app.domain.LocationModal
import net.haji.first_app.repositories.MainRepository

class MainViewModel {

    private val repository = MainRepository()

    fun loadLocations(): LiveData<MutableList<LocationModal>> {
        return repository.loadLocations()
    }
}