package com.example.cocktailusingcoroutines

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainServices {
    @GET("api/json/v1/1/search.php?f=a")
   suspend fun getList(): RecyclerListModel
}