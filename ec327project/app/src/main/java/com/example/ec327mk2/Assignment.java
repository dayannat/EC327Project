package com.example.ec327mk2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

/* Linked to Assignment via School_Class_With_Assignment class in the database. */
@Entity (tableName = "Assignment")
public class Assignment {

    @PrimaryKey
    public long aID;

    @ForeignKey
            (entity = Player_Profile.class,
                    parentColumns = "scID",
                    childColumns = "id_fClass",
                    onDelete = CASCADE
            )
    private long id_fClass;



    private String name;
    private Date dueDate;
    private String priority;
    private boolean isDue;

    //get()/set() methods
    public String getName() {return this.name;}
    public Date getDueDate() {return this.dueDate;}
    public String getPriority() {return this.priority;}
    public boolean getIsDue() {return this.isDue;}

    public void setName(String newName) {this.name = newName;}
    public void setDue(boolean state) {this.isDue = state;}
    public void setDueDate(Date newDate) {this.dueDate = newDate;}
    public void setPriority(String newPriority) {this.priority = newPriority;}

    //Constructor
    public Assignment(String name, Date dueDate, String priority) {
        if (dueDate.after(this.dueDate)) {
            this.isDue = true;
        } else {
            this.isDue = false;
        }
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    //TODO: checkTime(), complete(), getTimeUntilDue()

}
