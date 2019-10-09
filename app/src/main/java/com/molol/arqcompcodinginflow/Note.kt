package com.molol.arqcompcodinginflow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title :String?,
    var descripcion : String?,
    var priority : Int
) {



}

//https://developer.android.com/training/data-storage/room/defining-data#kotlin