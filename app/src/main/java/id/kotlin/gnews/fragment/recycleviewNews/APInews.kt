package id.kotlin.gnews.fragment.recycleviewNews

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface APInews {
    @GET("/rest/v1/news?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<newsdataAPI>>
}