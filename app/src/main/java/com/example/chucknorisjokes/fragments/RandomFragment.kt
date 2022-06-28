package com.example.chucknorisjokes.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.chucknorisjokes.ui.Model
import com.example.chucknorisjokes.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RandomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_random, container, false)
        val prevBTN: Button =view.findViewById(R.id.next)
        prevBTN.setOnClickListener{
            val fragment= NeverEndingFragment()
            val transaction=parentFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_container,fragment).commit()
        }
        return view

    }

    val retrofit=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://api.icndb.com/")
        .build()
    val jsonapi = retrofit.create(com.example.chucknorisjokes.api.jsonapi::class.java)
    val mcall: Call<List<Model>> = jsonapi.getInfo()
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