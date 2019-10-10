package com.molol.arqcompcodinginflow

import android.app.Application
import androidx.lifecycle.LiveData
import org.jetbrains.anko.doAsync

class NoteRepository {
    var noteDao : NoteDao? = null
    var allNotes: LiveData<List<Note>>? = null

    fun NoteRepository(application: Application) {
        val database = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
        allNotes = noteDao?.getAllNotes()
    }

    fun insert(note: Note) =
        doAsync {
            noteDao?.insert(note)
        }


    fun update(note: Note) {
        doAsync {
            noteDao?.update(note)
        }
    }

    fun delete(note: Note) {
        doAsync {
            noteDao?.delete(note)
        }
    }

    fun delelteAllNodes() =
        doAsync {
            noteDao?.deleteAll()
        }



//    fun getAllNotes(): LiveData<List<Note>>? {
//        return allNotes
//    }


//    class InsertNoteAsyncTask : AsyncTask {
//   }
}