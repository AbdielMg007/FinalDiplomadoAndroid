package com.mg.finaldiplomado.model.network

import com.mg.finaldiplomado.model.enties.CallProducts
import com.mg.finaldiplomado.model.enties.CallPublications
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiClient {

    @GET
    fun getProducts(@Url url:String): Call<CallProducts>

    @GET
    fun getPublications(@Url url:String): Call<CallPublications>


    
}