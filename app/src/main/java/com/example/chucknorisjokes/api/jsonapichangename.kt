package com.example.chucknorisjokes.api

import com.example.chucknorisjokes.ui.Model
import retrofit2.Call
import retrofit2.http.GET

interface jsonapichangename {
    //http://api.icndb.com/jokes/random?firstName=Chuck&lastName=Norris
    @GET(value = "jokes/random?firstName=Chuck&lastName=Norris")
    fun getInfo(): Call<List<Model>>
    @GET(value = "jokes/random?firstName=Chuck&lastName=Norris")
    fun getinfo(): ?firstName=, ?lastName=
}