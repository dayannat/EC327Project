import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/* Right now the Dao only retrieves the full class. I don't know if this will work with the many,
* many nested objects in each Player_Profile, but I think it will. Regardless, this will take more
* resources than if we implemented each object within Player_Profile and School_Class and
* Assignments in a way that the program can just grab from each of these when it needs too.
*/
@Dao
public interface profileDao {

    @Query ("Select * FROM Player_Profile")
    List<Player_Profile> getAllProfiles();

    @Query ("Select * FROM Player_Profile WHERE name == :inputName")
    Player_Profile loadOneProfile(String inputName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Player_Profile... Player_Profiles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(Player_Profile Player);

    @Update
    public void UpdateProfile(Player_Profile Player);

    @Delete
    void delete(Player_Profile profile);


}
