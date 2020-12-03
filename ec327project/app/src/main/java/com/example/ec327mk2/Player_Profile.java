/*package com.example.ec327mk2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

/*A lot has changed here. No longer does Player_Profile have its array, but instead it uses the
* second class Player_Profile_With_School_Class (a mouthful, I know) to link with it's classes.
 */
/*You may notice a very large amount of annoyed comments in these files. Don't mind them. They're
* simply the outlet of my frustration on this project. In the future, please actually teach the
* class how to use databases before assigning them as part of the final project. Thank you!
 *//*
@Entity (tableName = "Player_Profile")
public class Player_Profile {

    @PrimaryKey (autoGenerate = true)
    public long pID;

    private int points;
    private String name = null;

    @Ignore
    List<School_Class> classes = null;

    //set(), get(), and addition()/subtraction() methods. Nothing fancy.
    public int getPoints() {return this.points;}
    public String getName() {return this.name;}

    public void setPoints(int newPoints) {this.points = newPoints;}
    public void setName(String newName) {this.name = newName;}

    public void addPoints(int added) {this.points += added;}
    public void subPoints(int subbed) {this.points -= subbed;}

    //Constructor
    public Player_Profile(String name) {
        this.name = name;
        this.points = 0;
    }

    //Constructor... from the database. Look, I'm trying my best here
    public Player_Profile(Player_Profile_With_School_Classes PlayerDetails)
    {
        this.pID = PlayerDetails.getpID();
        this.name = PlayerDetails.getName();
        this.classes = this.getClasses(PlayerDetails.getAssignmentDetails());
    }

    private List<School_Class> getClasses(List<Player_Profile_With_School_Classes> PlayerClassesDetails)
    {
        for (School_Class_With_Assignments details : PlayerClassesDetails) {
            School_Class School_Class = details.getClass();
            School_Class.setAssignments(details.getAssignments());
            this.setClass(details.getClass())
        }
        return this.classes;
    }


}*/
