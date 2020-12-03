package com.example.ec327mk2;

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
 */
@Entity (tableName = "Profile")
public class Profile {

    @PrimaryKey (autoGenerate = true)
    public long pID;

    private int points;
    private String name = null;

    //set(), get(), and addition()/subtraction() methods. Nothing fancy.
    public int getPoints() {return this.points;}
    public String getName() {return this.name;}

    public void setPoints(int newPoints) {this.points = newPoints;}
    public void setName(String newName) {this.name = newName;}

    public void addPoints(int added) {this.points += added;}
    public void subPoints(int subbed) {this.points -= subbed;}

    //Constructor
    public Profile(String name) {
        this.name = name;
        this.points = 0;
    }
}
