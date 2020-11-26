import java.util.*; //For Date class
//may need to set all the 'dueDate = newDueDate' statement to dueDate.clone(newDueDate)

/*Current functions:
public Assignment(String newName, Date newDueDate, String newPriority)
public String getName()
public Date getDueDate()
public boolean getIsDue()
public String getPriority()
public void setName(String newName)
public void setDueDate(Date newDueDate)
public long timeUntilDue()
public void timeCheck()
*/

public class Assignment {
    
    private String name;
    private boolean isDue;
    private Date dueDate;
    private String priority;
    /* It was suggested to have a static ID for assignments
    but that discussion was a week ago and I don't remember
    what that meant exactly */

    //constructor
    public Assignment(String newName, Date newDueDate, String newPriority)
    {
        this.name = newName;
        this.dueDate = newDueDate;
        this.priority = newPriority;
        Calendar now = Calendar.getInstance();
        if (newDueDate.after(now.getTime())) //checks if the assignment is already due
        {
            this.isDue = true;
        } else 
        {
            this.isDue = false;
        }
    }

    //basic get functions below
    public String getName() { return this.name; }
    public Date getDueDate() { return this.dueDate; }
    public boolean getIsDue() { return this.isDue; }
    public String getPriority() { return this.priority; }
    //basic set functions below
    public void setName(String newName) { this.name = newName; }
    public void setDueDate(Date newDueDate) { this.dueDate = newDueDate; }
    //complex functions below
    public long timeUntilDue()
    {
        Calendar now = Calendar.getInstance();
        return (this.dueDate.getTime() - now.getTime().getTime()); //returns time in miliseconds(!)
    }

    public void timeCheck()
    {
        /*I have no idea how to code this yet.*/
        /* More accurately, I don't know how to get this to be run in
        the background/on start/every 30 minutes/etc*/
        Calendar now = Calendar.getInstance();
        if (this.dueDate.after(now.getTime()))
        {
            this.isDue = true;
        }
    }

}
