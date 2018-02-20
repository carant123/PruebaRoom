package com.proyecto.qr.retrofitrxjava.Room.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by Carlos on 17/02/2018.
 */


// podemos estblace como cloumnas unicas seleccionando los valores en el idex y agregando unique = true
@Entity(indices = {
        @Index( value = {"first_name", "last_name"},
        unique = true)})
class User2 {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @Ignore
    Bitmap picture;
}