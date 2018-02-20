package com.proyecto.qr.retrofitrxjava.RoomPrueba;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Carlos on 17/02/2018.
 */

@Entity(tableName = "usuario")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id_usuario;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "apellido")
    private String apellido;


    public Usuario() {
    }


    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
