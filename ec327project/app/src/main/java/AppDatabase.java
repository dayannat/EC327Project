/*This'll be the main database for the app.
* Right now we're only focusing on having 1 profile at a time.
 */

/* Does more code need to go here? Is it done as is? I don't know! */

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Player_Profile.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract profileDao profileDao();

    /*Actually make the bloody thing*/
}
