package ram.ramires.company3.data

import android.util.Log
import androidx.databinding.ObservableField
import ram.ramires.company3.api.CompanyService
import ram.ramires.company3.utilities.LOG2
import java.util.regex.Matcher
import java.util.regex.Pattern


class EmergencyRepositoriy(val service: CompanyService) {

    fun requestDeatil(id: String, detail: ObservableField<Company>){
        try {
            val result=service.getEmergencyInfo(id)?.execute()
            if(result!!.isSuccessful) {
                val responseString=result.body()?.string()
                Log.d(LOG2, "Emergency respon = " + responseString.toString())
                val entity= responseString?.let { warningParsing(it) }
                detail.set(entity)

            }else{

            }
        }
        catch (cause: Throwable){

        }
    }

    fun warningParsing(response: String): Company {
        //Parser
//=======================================
        val entity = Company()
        val pattern = "(id)(.*)(name)(.*)(img)(.*)(description)(.*)(lat)(.*)(lon)(.*)(www)(.*)(phone)(.*)"
        val r = Pattern.compile(pattern)
        val m:Matcher
        m = r.matcher(response)
        Log.d(LOG2, "A")
        val count = m.groupCount()
        Log.d(LOG2, "groupCount = $count")

        //Log.d(LOG2, "matcher = " + m.find())

        if (m.find()) {
            val count = m.groupCount()
            Log.d(LOG2, "B")
            for (i in 1..count) {
                Log.d(LOG2, m.group(i))
            }
            val id_temp = m.group(2)
            val id = id_temp.substring(id_temp.indexOf("\":\"") + 3, id_temp.indexOf("\",\""))
            val name_temp = m.group(4)
            val name = name_temp.substring(name_temp.indexOf("\":\"") + 3, name_temp.indexOf("\",\""))
            val img_temp = m.group(6)
            val img = img_temp.substring(img_temp.indexOf("\":\"") + 3, img_temp.indexOf("\",\""))
            val description_temp = m.group(8)
            val description = description_temp.substring(description_temp.indexOf("\":\"") + 3, description_temp.indexOf("\",\""))
            val lat_temp = m.group(10)
            val lat = lat_temp.substring(lat_temp.indexOf("\":") + 2, lat_temp.indexOf(",\"")).toDouble()
            val lon_temp = m.group(12)
            val lon = lon_temp.substring(lon_temp.indexOf("\":") + 2, lon_temp.indexOf(",\"")).toDouble()
            val www_temp = m.group(14)
            val www = www_temp.substring(www_temp.indexOf("\":\"") + 3, www_temp.indexOf("\",\""))
            val phone_temp = m.group(16)
            val phone = phone_temp.substring(phone_temp.indexOf("\":\"") + 3, phone_temp.indexOf("\"}]"))
            Log.d(LOG2, "String id = $id")
            Log.d(LOG2, "String name = $name")
            Log.d(LOG2, "String img = $img")
            Log.d(LOG2, "String description = $description")
            Log.d(LOG2, "String lat = $lat")
            Log.d(LOG2, "String lon = $lon")
            Log.d(LOG2, "String www = $www")
            Log.d(LOG2, "String phone = $phone")
            entity.setId(id)
            entity.setName(name)
            entity.setImg(img)
            entity.setDescription(description)
            entity.setLat(lat)
            entity.setLon(lon)
            entity.setWww(www)
            entity.setPhone(phone)

//=======================================
        }

            Log.d(LOG2, "C")
            return entity
    }
}