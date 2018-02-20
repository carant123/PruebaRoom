package com.proyecto.qr.retrofitrxjava.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.proyecto.qr.retrofitrxjava.MultipleResource;

/**
 * Created by Carlos on 17/02/2018.
 */

// se puede agregar las diferentes clases
/*@Database(entities = {User.class, MultipleResource.class}, version = 1)*/
public abstract class AppDatabase extends RoomDatabase {
/*    public abstract UserDao userDao();*/
}
