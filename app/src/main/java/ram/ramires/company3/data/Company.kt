package ram.ramires.company3.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "companyes")
class Company (
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("img")
    @Expose
    var img: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("lat")
    @Expose
    var lat: Double,

    @SerializedName("lon")
    @Expose
    var lon: Double,

    @SerializedName("www")
    var www: String,

    @SerializedName("phone")
    @Expose
    var phone: String )