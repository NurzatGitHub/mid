
package com.example.aviatickets.model.network

import retrofit2.Call
import retrofit2.http.GET
import com.example.aviatickets.model.entity.Offer

interface ApiService {
    @GET("offer_list")
    fun getOfferList(): Call<List<Offer>>
}