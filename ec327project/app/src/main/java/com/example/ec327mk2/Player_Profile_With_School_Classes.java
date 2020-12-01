/*
package com.example.ec327mk2;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

//Right now it demands this have the entity tag, which it shouldn't.
public class Player_Profile_With_School_Classes {
    @Embedded public Player_Profile profile;
    @Relation(
            parentColumn = "pID",
            entityColumn = "scID",
            entity = School_Class.class
    )
    public List<School_Class> classes;

   public Player_Profile_With_School_Classes(Player_Profile player_profile,
                                              List<School_Class> school_classes)
    {
        this.profile = player_profile;
        this.classes = school_classes;
    }

}
*/
