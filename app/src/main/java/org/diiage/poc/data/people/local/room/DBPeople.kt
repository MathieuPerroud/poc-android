package org.diiage.poc.data.people.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Peoples")
data class DBPeople(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)