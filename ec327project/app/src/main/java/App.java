import android.content.Context;

import androidx.room.Room;

/*
* Right now I have no idea if I'm calling the room Dao right, and I won't know until we fix the bloody
* context problem
* What is context?!
*/

/*Right now I've made a function for making a data base [which doesn't work, see context issues]
* but I have no idea how to check if there is already a database present, which is what I imagine
* is something we need to do
 */

/* I actually don't know how we'll access the Dao and the database, to be frank.
* Maybe it'll be a part of main application? I don't know. I don't know how Android works.
 */
public class App {

    /*Current functions:
    public void restart()
    public void retrieveData()
    public void saveData()
    public void makeProfile()
    public object getApplicationContext()
    public void make database()
    */

    /*literally none of the above functions work*/

    public static void main(String[] args) throws Exception {

    }

    /*This function resets the points var to 0 and removes all classes:
    A complete reset*/
    public void restart(Player_Profile player, profileDao Dao)
    {
        /*Code*/
        Dao.delete(player);
    }

    public void makeDataBase()
    {
        /*Apparently the Database is broken with context, and getApplicationContext is broken because
        I don't know what context is still.
         */
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Profiles").build();
    }

    //makes an actual profile, stores in database
    public void makeProfile(String name)
    {
        Player_Profile profile = new Player_Profile(name);

    }

    public void saveData(Context context,Player_Profile Profile, profileDao Dao) {
        /*Save all classes array into a file of unknown type*/
        Dao.UpdateProfile(Profile); //Non static function doesn't work for some reason.
    }

    public void loadData(String PlayerName, profileDao Dao)
    {
        /*Recovers all data from previous time the program was opened*/
        Player_Profile player = new Player_Profile;
        player = Dao.loadOneProfile(PlayerName);
        /* This would be safe as a proper clone method*/
    }

    private Object getApplicationContext() { //Context comes to **** me again
        /*On a non cynical note, I need context in order to use the database. However, I don't know
        * how to get context. Imagine how nice it would be if we were actually TAUGHT these things!
         */
        return deez_nuts; //Obviously not real
    }
}
