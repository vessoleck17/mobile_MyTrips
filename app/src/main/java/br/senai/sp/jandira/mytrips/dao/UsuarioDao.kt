package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario): Long

    @Query("Select * from tbl_usuarios where email = :email ")
    fun buscarUsuario (email: String): Usuario?
}