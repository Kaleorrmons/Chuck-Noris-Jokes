package com.example.chucknorisjokes.ui

import com.google.gson.annotations.SerializedName

class Model (
    val id:Int,
    val title:String,
    @SerializedName(value = "body")
    val mbody:String


)