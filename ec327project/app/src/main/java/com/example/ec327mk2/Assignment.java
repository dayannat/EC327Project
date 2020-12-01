package com.example.ec327mk2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

/*I've commented out anything that relates to date. It can't be recorded in Room in its current form,
* but I think I can figure out a way to get around it via data conversion.
 */
/*This is an issue with School_Class as well, but to make the foreign key work it needs to be public.
* gross.
 */
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
    public long id_fClass;



    private String name;
    //private Date dueDate;
    private String priority;
    private boolean isDue;
    private String ownerClass;

    //get()/set() methods
    public String getName() {return this.name;}
    //public Date getDueDate() {return this.dueDate;}
    public String getPriority() {return this.priority;}
    public boolean getIsDue() {return this.isDue;}
    public String getOwnerClass() {return this.ownerClass;}

    public void setName(String newName) {this.name = newName;}
    public void setDue(boolean state) {this.isDue = state;}
   // public void setDueDate(Date newDate) {this.dueDate = newDate;}
    public void setPriority(String newPriority) {this.priority = newPriority;}
    public void setOwnerClass(String newName) {this.ownerClass = newName;}

    //Constructor
    public Assignment(String name, /*Date dueDate,*/ String priority, String ownerClass) {
        /*if (dueDate.after(this.dueDate)) {
            this.isDue = true;
        } else {
            this.isDue = false;
        }*/
        this.ownerClass = ownerClass;
        this.name = name;
        //this.dueDate = dueDate;
        this.priority = priority;
    }

    //TODO: checkTime(), complete(), getTimeUntilDue(), actually getting date to be stored in ROOM

}
