package co.edu.uan.android.simpsonsbottomnavigation312.services

import co.edu.uan.android.simpsonsbottomnavigation312.ui.dashboard.CatImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApi {

    @GET("images/search/")
    suspend fun search(@Query("limit") n:Int) : Array<CatImage>

    @GET("breeds")
    fun breeds(): Int

    companion object {

        private var catsApi: CatsApi? = null
        fun getInstance(): CatsApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            if(catsApi==null)
                catsApi = retrofit.create(CatsApi::class.java)
            return catsApi!!
        }
    }
}