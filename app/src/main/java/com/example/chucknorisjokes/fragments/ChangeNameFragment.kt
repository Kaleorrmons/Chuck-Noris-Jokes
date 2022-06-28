package com.example.chucknorisjokes.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chucknorisjokes.R
import com.example.chucknorisjokes.ui.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChangeNameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false)

        val retrofit= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.icndb.com")
            .build()
        val jsonapichangename = retrofit.create(com.example.chucknorisjokes.api.jsonapi::class.java)
        val mcall: Call<List<Model>> = jsonapichangename.getInfo()
        mcall.enqueue(object : Callback<List<Model>>
        {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                val mmodel:List<Model> = response.body()!!
                val stringBuilder = StringBuilder()
                for (i in mmodel){
                    stringBuilder.append((i.title))
                    stringBuilder.append(("\n"))
                    stringBuilder.append((i.id))
                    stringBuilder.append(("\n"))
                    stringBuilder.append((i.mbody))
                    stringBuilder.append(("\n"))
                    stringBuilder.append(("\n"))
                }

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.e("Error",t.message.toString())

            }



        }
    }

}