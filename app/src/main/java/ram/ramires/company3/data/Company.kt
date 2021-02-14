package ram.ramires.company3.data

import androidx.annotation.NonNull
class Company {
    private var id: String? = null

    private var name: String? = null
    @NonNull
    private var img: String=""

    private var description: String? = null

    private var lat: Double? = null

    private var lon: Double? = null

    private var www: String? = null

    private var phone: String? = null

    private var city: String?=null


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

}