package com.example.ppapb_tugaspertemuan12_crud

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Note(
    val id: Int,
    val title: String,
    val content: String,
)
