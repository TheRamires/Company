package ram.ramires.company3.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    @Query("SELECT * FROM companyes WHERE id = :id")
    fun getData(id: Int): List<Company>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(company: Company)
}