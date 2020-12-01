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

    //getAll() methods
    //Apparently these aren't needed. Commenting them out until we figure out column linking.

    /*
    @Transaction
    @Query("SELECT * FROM Player_Profile")
    public List<Player_Profile_With_School_Classes> getPlayerProfilesWithSchoolClasses();

    @Transaction
    @Query("SELECT * FROM School_Class")
    public List<School_Class_With_Assignments> getSchoolClassesWithAssignments();
     */

    @Query("SELECT * FROM Player_Profile")
    public List<Player_Profile> getPlayerProfiles();

    @Query("SELECT * FROM School_Class")
    public List<School_Class> getSchoolClasses();

    @Query("SELECT * FROM Assignment")
    public List<Assignment> getAssignments();

    //getSpecific() these use a name to return one value
    @Query("SELECT * FROM Player_Profile WHERE name == :name")
    public Player_Profile getOneProfile(String name);

    @Query("SELECT * FROM School_Class WHERE name == :name")
    public School_Class getOneClass(String name);

    @Query("SELECT * FROM Assignment WHERE name == :name")
    public Assignment getOneAssignment(String name);

    //Update() These accept any number of inputted parameters and updates them in the database.
    @Update
    public void updateProfiles(Player_Profile ... profiles);

    @Update
    public void updateSchoolClasses(School_Class ...classes);

    @Update
    public void updateAssignments(Assignment ...Assignments);

    /* I don't believe I need to update the linkage classes.*/

    //Insert() These make new things in the database. They'll need to be initialized first in main.
    /*I don't know how to make these linked with their child classes*/
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProfile(Player_Profile profile);

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSchoolClass(School_Class schoolClass);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAssignment(Assignment assignment);


    //Delete() if you need to axe a piece of data.
    @Delete
    public void deletePlayerProfiles(Player_Profile ...profiles);

    @Delete
    public void deleteSchoolClasses(School_Class ...classes);

    @Delete
    public void deleteAssignments(Assignment ...assignments);
    /*May need delete methods for the two linkage classes.*/

    //Testing out linkage fields method.
    @Query("SELECT * FROM School_Class WHERE ownerClass == :name")
    public List<School_Class> getOneClassTest(String name);

}