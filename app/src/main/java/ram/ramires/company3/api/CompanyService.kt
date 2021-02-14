package ram.ramires.company3.api

import kotlinx.coroutines.Deferred
import ram.ramires.company3.data.Company
import ram.ramires.company3.utilities.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CompanyService {
    @GET("test.php?")
    fun getCompanyInfo(@Query("id") id: String): Call<List<Company>>?

    @GET("test.php")
    fun getCompanyList(): Call<List<Company>>?

    companion object {
        fun create(): CompanyService {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(
                    CompanyService::class.java
                )
        }

    }
}