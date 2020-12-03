package com.example.ec327mk2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

/*I've commented out anything that relates to date. It can't be recorded in Room in its current form,
* but I think I can figure out a way to get around it via data conversion.
 */

/*Date can't be stored in Room, but Long can, and we can convert freely back and forth.*/

/* Linked to Assignment via School_Class_With_Assignment class in the database. */
@Entity (tableName = "Assignment")
public class Assignment {

    @PrimaryKey
    public long aID;

    private String name;
    //private Date dueDate;
    private String priority;
    private boolean isDue;
    private long savedDate; //This is in long form!

    //get()/set() methods
    public String getName() {return this.name;}
    //public Date getDueDate() {return this.dueDate;}
    public String getPriority() {return this.priority;}
    public boolean getIsDue() {return this.isDue;}
    public long getSavedDate() {return savedDate;}

    public void setName(String newName) {this.name = newName;}
    public void setDue(boolean state) {this.isDue = state;}
   // public void setDueDate(Date newDate) {this.dueDate = newDate;}
    public void setPriority(String newPriority) {this.priority = newPriority;}

    //overloaded setSavedDate Function
    public void setSavedDate(Calendar date) {
        this.savedDate =  date.getTimeInMillis();
    }
    public void setSavedDate(Long date) {
        this.savedDate = date;
    }
    //empty constructor to appease the room gods
    public Assignment(){}
    
    //Constructor
    public Assignment(String name, Calendar due, String priority) {
        Calendar now = Calendar.getInstance();
        if (due.getTimeInMillis() <= now.getTimeInMillis()) {
            this.isDue = true;
        } else {
            this.isDue = false;
        }
        this.name = name;
        savedDate = due.getTimeInMillis();
        this.priority = priority;
    }

    //Converting Calendar values to Longs for storage and vice versa for reading
    public long dateToLong(Calendar time)
    {
        return time.getTimeInMillis();
    }

    //returns time until due in the form [Weeks,Days,Hours,Minutes]
    public Long[] timeUntilDue()
    {
        Long[] timeArray = new Long[4];
        Long now = Calendar.getInstance().getTimeInMillis();

        timeArray[0] = (savedDate-now)%(int)(6.048*Math.pow(10,8)); //weeks
        now -= timeArray[0];
        timeArray[1] = now % (int)(8.64*Math.pow(10,7)); //days
        now -= timeArray[1];
        timeArray[2] = now % (int)(3.6*Math.pow(10,6)); //hours
        now -= timeArray[2];
        timeArray[3] = now % 60000;
        return timeArray;
    }

    //testing if the assignment is now due
    public void checkTime()
    {
        Calendar now = Calendar.getInstance();
        if (now.getTimeInMillis() >= savedDate)
        {
            setDue(true);
        }
        else setDue(false);
    }

    //placeholder values for rewarded points
    //adds to the profile's points upon completion and deletes the assignment.
    public void complete(Profile profile, profileDao Dao)
    {
        if (this.getPriority() == "low")
        {
            profile.addPoints(10);
        } else if (this.getPriority() == "medium")
        {
            profile.addPoints(20);
        }else if (this.getPriority() == "high")
        {
            profile.addPoints(50);
        }
        Dao.deleteAssignments(this);
    }

}
