import java.util.Date;
import java.util.*; 

/*Current functions:
public School_Class()
public School_Class(String name)
public String getName()
public int getAssignmentsNum()
public void setName(String newName)
public void addAssignment(String name, Date date)
public void deleteAssignment(String name)
public int completeAssignment(String name)
*/

public class School_Class {
    
    private String name;
    Vector<Assignment> assignments = new Vector<Assignment>(0);

    //basic constructor
    public School_Class()
    {
        this.name = "";
    }
    //parameter constructor
    public School_Class(String name)
    {
        this.setName(name);
    }
    //basic get functions below
    public String getName() { return this.name; }
    public int getAssignmentsNum() { return this.assignments.size(); }
    //basic set functions below
    public void setName(String newName) { this.name = newName; }
    //complex functions below
    public void addAssignment(String name, Date date, String priority)
    {
        assignments.add(new Assignment(name, date, priority));
    }

    public void deleteAssignment(String name)
    {
        int index = -1;
        for (int i = 0; i < assignments.size(); i++)
        {
            if (assignments.get(i).getName() == name)
            {
                index = i;
            }
        }

        if (index >= 0)
        {
            assignments.remove(index);
        } else
        {
            /*throw error*/
        }

    }

    public int completeAssignment(String name)
    {
        String priority;
        int index = -1;
        for (int i = 0; i < assignments.size(); i++)
        {
            if (assignments.get(i).getName() == name)
            {
                index = i;
            }
        }

        if (index >= 0)
        {
            priority = assignments.get(index).getPriority();
            if (priority == "low" && assignments.get(index).getIsDue() == false)
            {
                deleteAssignment(name);
                return 10; //arbitrary points value
            } else if (priority == "medium" && assignments.get(index).getIsDue() == false)
            {
                deleteAssignment(name);
                return 20; //arbitrary points value
            } else if (priority == "high" && assignments.get(index).getIsDue() == false)
            {
                deleteAssignment(name);
                return 30; //arbitrary points value
            }
        } else
        {
            /*throw exception*/
        }

        return 0; //if it gets to here somehow it just won't affect the total points.

    }
}
