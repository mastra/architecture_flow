package com.molol.arqcompcodinginflow

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(Note::class), version=1)
abstract class NoteDatabase : RoomDatabase() {
    companion object {
        var instance : NoteDatabase? = null

        fun getInstance(context: Context) : NoteDatabase {
            return instance ?:
                synchronized(this) {
                    val i = Room.databaseBuilder(
                        context.applicationContext, NoteDatabase::class.java, "note_databse"
                        ).fallbackToDestructiveMigration()
                        .build()
                    instance = i
                    return i
                }
        }
    }

    abstract fun noteDao() : NoteDao
}