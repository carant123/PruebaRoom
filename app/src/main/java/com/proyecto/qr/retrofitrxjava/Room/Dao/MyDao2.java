package com.proyecto.qr.retrofitrxjava.Room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.proyecto.qr.retrofitrxjava.Room.User;

import java.util.List;

/**
 * Created by Carlos on 17/02/2018.
 */

@Dao
public interface MyDao2 {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);
}
