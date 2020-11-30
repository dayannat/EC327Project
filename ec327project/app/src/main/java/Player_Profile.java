import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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


/*I'm going to start throwing around annotations on this badboy to try and get it to work with room
* Here goes nothing. Luckily, it seems that the annotations tend to be yellow.
 */
@Entity
public class Player_Profile {

    /*I don't like making these public but that's how the room example does it.
    * I have a feeling in the future we may be able to return them to private via putting
    * @Column Info over the get() functions instead, but that's only a hunch. I'd rather get it
    * working this way first. So much to get done...
    * Checking later in the documentation this is the case. Add it to the TODO.
     */

    @PrimaryKey (autoGenerate = true) //don't know what this'll do
    public int userID;

    @ColumnInfo(name = "name")
    public String name = null;

    @ColumnInfo(name = "points")
    public int points;

    @ColumnInfo(name = "classes") //May need to @embed this, though not sure yet.
    public ArrayList<School_Class> classes = null;

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