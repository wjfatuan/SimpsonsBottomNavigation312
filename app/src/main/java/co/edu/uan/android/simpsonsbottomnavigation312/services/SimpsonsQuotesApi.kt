package co.edu.uan.android.simpsonsbottomnavigation312.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonsQuotesApi {

    @GET("quotes")
    suspend fun quotes(@Query("count") n: Int): List<Quote>

    companion object {

        fun getInstance(): SimpsonsQuotesApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://thesimpsonsquoteapi.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(SimpsonsQuotesApi::class.java)
        }

    }

}