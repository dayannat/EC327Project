package com.example.ec327mk2;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class Player_Profile_With_School_Classes {
    @Embedded
    public Player_Profile profile;
    @Relation(
            parentColumn = "pID",
            entityColumn = "scID"
    )
    public List<School_Class> classes;

    public Player_Profile_With_School_Classes(Player_Profile player_profile, List<School_Class> school_classes)
    {
        this.profile = player_profile;
        this.classes = school_classes;
    }

}
