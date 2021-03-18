package com.nguyen_minh_an.minhan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Update
    int updateUser(User user);

    @Delete
    int deleteUser(User user);

    @Query("Select * from user where id = :id")
    User findUser(int id);

    @Query("Select * from user")
    List<User> getAllUser();

    @Query("Select * from user where username like :name")
    List<User> searchUser(String name);
}
