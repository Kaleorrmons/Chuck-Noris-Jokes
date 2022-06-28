package com.example.chucknorisjokes.api

import com.example.chucknorisjokes.ui.Model
import retrofit2.Call
import retrofit2.http.GET

interface jsonapi {
    //http://api.icndb.com/jokes/random
    @GET(value = "jokes/random")
    fun getInfo(): Call<List<Model>>
}