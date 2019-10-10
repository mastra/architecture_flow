package com.molol.arqcompcodinginflow

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import org.jetbrains.anko.doAsync

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
                        .addCallback(roomCallback)
                        .build()
                    instance = i
                    return i
                }
        }

        val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                doAsync {
                    instance?.noteDao()?.insert(Note( "Titulo 1",  "Descripcion 1"))
                    instance?.noteDao()?.insert(Note( "Titulo 2",  "Descripcion 2"))
                    instance?.noteDao()?.insert(Note( "Titulo 3",  "Descripcion 3"))

                }
            }
        }
    }

    abstract fun noteDao() : NoteDao
}