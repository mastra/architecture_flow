package com.molol.arqcompcodinginflow

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Delete from note_table")
    fun deleteAll()

    @Query("Select * from note_table order by priority desc")
    fun getAllNotes() : LiveData<List<Note>>


}