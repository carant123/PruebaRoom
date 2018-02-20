package com.proyecto.qr.retrofitrxjava.Room.Model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Carlos on 17/02/2018.
 */
// utilizando la etiqueta Embedded puede enlaza los datos de otra clase
@Entity
class User3 {
    @PrimaryKey
    public int id;

    public String firstName;

    @Embedded
    public Address address;
}

