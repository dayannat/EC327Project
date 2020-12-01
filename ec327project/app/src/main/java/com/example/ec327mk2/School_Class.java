package com.example.ec327mk2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/* Like the Player_Profile class this class uses a third class to link it to assignments in the
* database. In turn, it is lined to Player_Profile.
 */
import static androidx.room.ForeignKey.CASCADE;

@Entity (tableName = "School_Class")
public class School_Class {

    @PrimaryKey
    public long scID;

    @ForeignKey
            (entity = Player_Profile.class,
            parentColumns = "pID",
            childColumns = "id_fProfile",
            onDelete = CASCADE
            )
    public long id_fProfile;

    private String name;
    private String ownerClass;

    //get()/set() methods.
    public String getName() {return this.name;}
    public String getOwnerClass() {return this.ownerClass;}

    public void setName(String newName) {this.name = newName;}
    public void setOwnerClass(String newName) {this.name = newName;}

    //constructor
    public School_Class(String name, String ownerClass) {

        this.name = name;
        this.ownerClass = ownerClass;
    }
}
