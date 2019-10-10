package com.molol.arqcompcodinginflow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title :String?,
    var descripcion : String?,
    var priority : Int = 0
) {

    constructor( t: String, d:String) : this(0, t, d, 0) {

    }

}

//https://developer.android.com/training/data-storage/room/defining-data#kotlin