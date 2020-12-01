/*
package com.example.ec327mk2;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;


public class School_Class_With_Assignments {
    @Embedded public School_Class School_Class;
    @Relation(
            parentColumn = "scID",
            entityColumn = "aID",
            entity = Assignment.class
    )
    public List<Assignment> assignments;

    public School_Class_With_Assignments(School_Class school_class, List<Assignment> assignments)
    {
        this.School_Class = school_class;
        this.assignments = assignments;
    }
}
*/