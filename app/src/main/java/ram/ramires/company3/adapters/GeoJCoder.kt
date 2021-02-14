package ram.ramires.company3.adapters

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import java.io.IOException
import java.util.*

class GeoJCoder(private val mcontext: Context) {
    private var city: String? = null
    private var addresses: MutableList<Address>? = null

    /*------- Geocoder getCityName ----------------------------------------------------- */
    fun getCityName(latitude: Double, longitude: Double): String? {
        val gcd = Geocoder(mcontext, Locale.getDefault())
        val addresses: List<Address>
        try {
            addresses = gcd.getFromLocation(
                latitude,
                longitude, 1
            )
            if (addresses.size != 0) {
                city = addresses[0].locality
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return city
    }
}
