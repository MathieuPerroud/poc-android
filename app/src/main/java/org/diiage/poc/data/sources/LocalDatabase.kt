package org.diiage.poc.data.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import org.diiage.poc.data.people.local.room.DBPeople
import org.diiage.poc.data.people.local.room.PeopleDao

@Database(entities = [
    DBPeople::class
], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao

}
