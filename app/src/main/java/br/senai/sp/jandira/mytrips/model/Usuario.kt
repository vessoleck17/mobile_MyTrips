package br.senai.sp.jandira.mytrips.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val mais18: Boolean = false
)
