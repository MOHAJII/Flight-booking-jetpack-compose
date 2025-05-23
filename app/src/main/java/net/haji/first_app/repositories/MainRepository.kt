package net.haji.first_app.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import net.haji.first_app.domain.LocationModal

class MainRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadLocations(): LiveData<MutableList<LocationModal>> {
        val listData = MutableLiveData<MutableList<LocationModal>>()
        val ref = firebaseDatabase.getReference("Locations")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<LocationModal>()
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(LocationModal::class.java)
                    item?.let { list.add(it) }
                    listData.value = list
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listData
    }
}