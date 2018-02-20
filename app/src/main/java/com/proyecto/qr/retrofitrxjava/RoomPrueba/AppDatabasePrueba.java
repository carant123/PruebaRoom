package com.proyecto.qr.retrofitrxjava.RoomPrueba;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.provider.ContactsContract;

import com.proyecto.qr.retrofitrxjava.MultipleResource;
import com.proyecto.qr.retrofitrxjava.Room.User;
import com.proyecto.qr.retrofitrxjava.Room.UserDao;

/**
 * Created by Carlos on 17/02/2018.
 */

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabasePrueba extends RoomDatabase {
    public abstract DatabaseDAO databaseDao();
}
