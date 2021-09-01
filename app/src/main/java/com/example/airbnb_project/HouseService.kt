package com.example.airbnb_project

import retrofit2.Call
import retrofit2.http.GET

//api정보(json형식)를 불러와서 해당정보를 불러온다. -> retrofit기능
interface HouseService {
    @GET("/v3/511c37d3-79c1-455f-9efb-98b5d594e640")
    fun getHouseList(): Call<HouseDto>
}