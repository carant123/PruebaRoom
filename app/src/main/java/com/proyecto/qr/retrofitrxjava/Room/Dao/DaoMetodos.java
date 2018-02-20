package com.proyecto.qr.retrofitrxjava.Room.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.proyecto.qr.retrofitrxjava.Room.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Carlos on 17/02/2018.
 */

public interface DaoMetodos {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);

    // permite la actualizacion de elemento mediante el primary key del modelo
    @Update
    public void updateUsers(User... users);

    // borra un usuario mediante la collecion de usuario o ususario utilizanodo el primary key
    @Delete
    public void deleteUsers(User... users);

    @Query("SELECT * FROM user")
    public User[] loadAllUsers();

    // pasando parametros
    @Query("SELECT * FROM user WHERE age > :minAge")
    public User[] loadAllUsersOlderThan(int minAge);

    // codiciones
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
            + "OR last_name LIKE :search")
    public List<User> findUserWithName(String search);


    // regresar solo ciertas columnas
    @Query("SELECT first_name, last_name FROM user")
    public List<User> loadFullName();

    // podemos poder una condicion en una lista
    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
    public List<User> loadUsersFromRegions(List<String> regions);

    // si quieres actualizar mientras haya cambios regresa con un valor liveData
    // livedata genera todos los metodos necesario cuando la base de datos es actualizada
    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
    public LiveData<List<User>> loadUsersFromRegionsSync(List<String> regions);

    // programacion reactiva puede regresar objetos tipo flowable  y publisher
    @Query("SELECT * from user where id = :id LIMIT 1")
    public Flowable<User> loadUserById(int id);

    // puede regresar mediante un cursor
    @Query("SELECT * FROM user WHERE age > :minAge LIMIT 5")
    public Cursor loadRawUsersOlderThan(int minAge);

    // uso de query multiples
    @Query("SELECT * FROM book "
            + "INNER JOIN loan ON loan.book_id = book.id "
            + "INNER JOIN user ON user.id = loan.user_id "
            + "WHERE user.name LIKE :userName")
    public List<User> findBooksBorrowedByNameSync(String userName);


}
