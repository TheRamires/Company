package ram.ramires.company3.data

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import ram.ramires.company3.adapters.GeoJCoder
import ram.ramires.company3.api.CompanyService
import java.util.concurrent.Executors

val BACKGROUND = Executors.newFixedThreadPool(2)
interface  Repository {
    suspend fun requestList(list: MutableLiveData<List<Company>>){}
    suspend fun requestDetail(id:String, detail: ObservableField<Company>){}

}
    class CompanyRepositoriy (val service: CompanyService, var geoJCoder: GeoJCoder) : Repository {

        override suspend fun requestList(list: MutableLiveData<List<Company>>) {
            try {
                val result= service.getCompanyList()?.execute()
                if(result!!.isSuccessful){
                    Log.d("myLog","requestList result is "+result.body()!!.size)
                    list.postValue(result.body())

                }else{
                    Log.d("myLog","requestList is full")
                }

            }catch(cause: Throwable){
                Log.d("myLog","requestList is catch "+cause )

            }
        }
        override suspend fun requestDetail(id: String, detail: ObservableField<Company>) {
            try {
                val result= service.getCompanyInfo(id)?.execute()
                if(result!!.isSuccessful){
                    Log.d("myLog","requestDetail result is "+result.body()!!.size)

                    var entity=result.body()?.get(0)
                    var lattitude=entity?.getLat()
                    var longitude=entity?.getLon()
                    if (lattitude!=0.0 && longitude!=0.0){
                        var cityName=geoJCoder.getCityName(lattitude!!, longitude!!)
                        entity?.setCity(cityName)
                        Log.d("myLog",cityName+""+ entity?.getCity())
                    } else {Log.d("myLog",lattitude.toString()+" "+longitude)}
                    detail.set(entity)

                }else{
                    Log.d("myLog","requestDetail is full")

                }

            }catch(cause: Throwable){
                Log.d("myLog","requestDetail is catch "+cause )


            }
        }
}

