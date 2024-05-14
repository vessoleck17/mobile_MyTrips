package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import br.senai.sp.jandira.mytrips.dao.UsuarioDb
import br.senai.sp.jandira.mytrips.model.Usuario

class UsuarioRepositorio (context: Context) {

    private val db = UsuarioDb.getBancoDeDados(context).UsuarioDao()

    fun salvar(usuario: Usuario): Long {
        return db.salvar(usuario)
    }

    fun verificacao(email: String, senha: String): Boolean {
        val usuario = db.buscarUsuario(email)
        return usuario != null && usuario.senha == senha
    }
}