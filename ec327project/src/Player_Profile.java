import java.util.*; //for ArrayList

/*Current functions:
public Player_Profile()
public Player_Profile(String name)
public String getName()
public ArrayList<School_Class> getClasses()
public int getPoints()
public void setPoints(int newTotal)
public void addPoints(int newAdd)
public void subtractPoints(int newSub)
public void setName(String newName)
public void newClass(String name)
public void removeClass(String name)
public School_Class getByName(String name)
*/


public class Player_Profile {

    private String name = null;
    private int points;
    ArrayList<School_Class> classes = null;

    //default constructor
    public Player_Profile()
    {
        this.classes = new ArrayList<School_Class>(0);
        this.points = 0;
    }
    //parameter constructor
    public Player_Profile(String newName)
    {
        this.name = newName;
        this.points = 0;
        this.classes = new ArrayList<School_Class>(0);
    }

    //basic get functions
    public String getName() { return this.name; }
    public int getPoints()  { return this.points; }
    public ArrayList<School_Class> getClasses() { return classes; }
    //basic set functions
    public void setName(String newName) { this.name = newName; }
    public void setPoints(int newTotal) { this.points = newTotal; }
    //add and subtract functions
    public void addPoints(int newAdd) { this.points+=newAdd; }
    public void subtractPoints(int newSub) { this.points-=newSub; }

    //complex functions
    public void newClass(String name) 
    {
        this.classes.add(new School_Class(name));
    }

    public void removeClass(String name)
    {
        /*Java apparently doesn't have a true delete capability.
        Instead this function just gets rid of an element in the class's
        ArrayList.*/  
        int index = -1;
        for (int i = 0; i < classes.size(); i++)
        {
            if (classes.get(i).getName() == name)
            {
                index = i;
            }
        }

        if (index >= 0)
        {
            classes.remove(index);
        } else
        {
            /*throw error*/
        }
    }

    public School_Class getByName(String name)
    {
        int index = -1;
        for (int i = 0; i < classes.size(); i++)
        {
            if (classes.get(i).getName() == name)
            {
                index = i;
            }
        } 
        
        if (index>= 0)
        {
            return this.classes.get(index);
        } else
        {
            /*throw exception */
        }

        return null;
    }
}