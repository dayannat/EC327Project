package com.example.ec327mk2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

/* This object is how we actually work with the data in the database, using the largely self
 * explanatory classes below. I think it'll work without specifying which parent class owns
 * each child in our two one to many relationships, but I may be wrong.
 */
@Dao
public interface profileDao {

    @Query("SELECT * FROM Profile")
    public List<Profile> getPlayerProfiles();

    @Query("SELECT * FROM Assignment")
    public List<Assignment> getAssignments();

    //getSpecific() these use a name to return one value
    @Query("SELECT * FROM Profile WHERE name == :name")
    public Profile getOneProfile(String name);

    @Query("SELECT * FROM Assignment WHERE name == :name")
    public Assignment getOneAssignment(String name);

    //Update() These accept any number of inputted parameters and updates them in the database.
    @Update
    public void updateProfiles(Profile ... profiles);

    @Update
    public void updateAssignments(Assignment ...Assignments);

    //Insert() These make new things in the database. They'll need to be initialized first in main.
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProfile(Profile profile);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAssignment(Assignment assignment);


    //Delete() if you need to axe a piece of data.
    @Delete
    public void deletePlayerProfiles(Profile ...profiles);

    @Delete
    public void deleteAssignments(Assignment ...assignments);
    /*May need delete methods for the two linkage classes.*/
}