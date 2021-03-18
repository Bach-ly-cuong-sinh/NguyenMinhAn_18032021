package com.nguyen_minh_an.minhan;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "useremail")
    public String useremail;

    @ColumnInfo(name = "userphone")
    public String userphone;

    @ColumnInfo(name = "gender")
    public String gender;

}
