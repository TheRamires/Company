package ram.ramires.company3.data

import androidx.annotation.NonNull
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Company: BaseObservable() {
    private var id: String? = ""

    private var name: String? = ""
    @NonNull
    private var img: String=""

    private var description: String? = ""

    private var lat: Double? = 0.0

    private var lon: Double? = 0.0

    private var www: String? = ""

    private var wwwIsFull: Boolean=false

    private var phone: String? = ""

    private var phoneIsFull: Boolean=false

    private var city: String?=""

    private var cityIsFull: Boolean=false


    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getImg(): String? {
        return img
    }

    fun setImg(img: String) {
        this.img = img!!
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getLat(): Double? {
        return lat
    }

    fun setLat(lat: Double?) {
        this.lat = lat
    }

    fun getLon(): Double? {
        return lon
    }

    fun setLon(lon: Double?) {
        this.lon = lon
    }

    fun getWww(): String? {
        return www
    }

    fun setWww(www: String?) {
        this.www = www
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone
    }
    fun getCity(): String? {
        return city
    }

    fun setCity(city: String?) {
        this.city = city
    }

    fun getCityIsFool(): Boolean {
        if (!city.equals("")){
            return true
        }else{
            return false
        }
    }
    fun setCityIsFool(bool: Boolean){
        cityIsFull=bool
    }

    fun getPhoneIsFool(): Boolean {
        if (!phone.equals("")){
            return true
        }else{
            return false
        }
    }

    fun setPhoneIsFool(bool: Boolean){
        phoneIsFull=bool
    }
    fun getWwwIsFool(): Boolean {
        if (!www.equals("")){
            return true
        }else{
            return false
        }
    }

    fun setWwwIsFool(bool: Boolean){
        wwwIsFull=bool
    }

}