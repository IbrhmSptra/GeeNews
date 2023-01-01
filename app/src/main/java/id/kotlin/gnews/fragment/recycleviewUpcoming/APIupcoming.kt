package id.kotlin.gnews.fragment.recycleviewUpcoming

import id.kotlin.gnews.fragment.recycleviewNews.newsdataAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface APIupcoming {
    @GET("/rest/v1/upcoming?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<upcomingAPI>>
}