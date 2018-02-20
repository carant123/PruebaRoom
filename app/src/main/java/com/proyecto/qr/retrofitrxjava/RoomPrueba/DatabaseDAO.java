package com.proyecto.qr.retrofitrxjava.RoomPrueba;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.proyecto.qr.retrofitrxjava.Room.User;

import java.util.List;

/**
 * Created by Carlos on 17/02/2018.
 */
@Dao
public interface DatabaseDAO {

    @Query("SELECT * FROM usuario")
    public List<Usuario> GetUsuarios();

    @Insert
    public void InsertUsuario(Usuario usuario);

}
