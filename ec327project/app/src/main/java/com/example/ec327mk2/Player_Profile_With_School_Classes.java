/*
package com.example.ec327mk2;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

//Right now it demands this have the entity tag, which it shouldn't.
public class Player_Profile_With_School_Classes {

    @Embedded public Profile profile;

    @Relation(
            parentColumn = "pID",
            entityColumn = "scID",
            entity = School_Class.class
    )
    public List<School_Class> classes;

    //Have to have empty constructors to appease the Room gods
    public Player_Profile_With_School_Classes(){}

    public Player_Profile_With_School_Classes(Profile Player_Profile,
                                              List<School_Class> School_Class)
    {
        this.profile = Profile;
        this.classes = School_Class;
    }

}
*/
