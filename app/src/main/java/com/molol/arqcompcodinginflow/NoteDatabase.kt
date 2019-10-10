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
            if (instance==null ) {
                synchronized(this) {
                    val i = Room.databaseBuilder(
                        context.applicationContext, NoteDatabase::class.java, "note_databse"
                    ).build()
                    instance = i
                    return i
                }
            }
            return instance!!
        }
    }

    abstract fun noteDao() : NoteDao
}