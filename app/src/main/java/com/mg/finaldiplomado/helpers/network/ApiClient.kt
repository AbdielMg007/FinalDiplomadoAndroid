package com.mg.finaldiplomado.helpers.network

import com.mg.finaldiplomado.helpers.enties.CallPublications
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiClient {

    @GET
    fun getPublications(@Url url:String): Call<CallPublications>
    
}