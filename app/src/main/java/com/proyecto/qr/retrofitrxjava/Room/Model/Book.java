package com.proyecto.qr.retrofitrxjava.Room.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.proyecto.qr.retrofitrxjava.Room.User;

/**
 * Created by Carlos on 17/02/2018.
 */

//podemos establece una relacion tomando la entidad relacionado con una etiqueta foriegin key
@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user_id"))
class Book {
    @PrimaryKey
    public int bookId;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}