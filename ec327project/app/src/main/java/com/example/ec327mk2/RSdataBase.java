package com.example.ec327mk2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/* This is the database class, from which everything else will be built. I'm pretty sure that
* we don't need to worry about making new ones, since room is all about making one database for
*  the whole app.
 */
@Database(entities = {Player_Profile.class, School_Class.class, Assignment.class,
                        Player_Profile_With_School_Classes.class,
                        School_Class_With_Assignments.class}, exportSchema = false, version = 1)
public abstract class RSdataBase extends RoomDatabase {

    private static final String DB_NAME = "RSdataBase";
    private static RSdataBase instance;

    /* This particularly occult block of code I believe checks if there is an identical database
    * before making a new one. Regardless, it uses instances and context, which I don't understand.
     */
    public static synchronized RSdataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), RSdataBase.class,
                    DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return instance;
    }

    /* This Dao object is how we will always interact with the data in the database, using the
    * functions found in its class file.
    * */
    public abstract profileDao profileDao();
}