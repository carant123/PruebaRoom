package com.proyecto.qr.retrofitrxjava.Room.Model;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by Carlos on 17/02/2018.
 */

public class Address {
    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;
}
