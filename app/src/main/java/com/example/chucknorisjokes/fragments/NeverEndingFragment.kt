package com.example.chucknorisjokes.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NeverEndingFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    var rowsArrayList: ArrayList<String> = ArrayList()
    var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        recyclerView = findViewById(R.id.recyclerView)
        populateData()
        initAdapter()
        initScrollListener()
    }
    private fun initScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() ==
                        rowsArrayList.size − 1) {
                        //bottom of list!
                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }
    private fun initAdapter() {
        recyclerViewAdapter = RecyclerViewAdapter(rowsArrayList)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = recyclerViewAdapter
    }
    private fun populateData() {
        for (i in 0..9) {
            rowsArrayList.add("Number $i")
        }
    }
    private fun loadMore() {
        rowsArrayList.add(null.toString())
        recyclerViewAdapter.notifyItemInserted(rowsArrayList.size − 1)
        val handler = Handler()
        handler.postDelayed(Runnable {
            rowsArrayList.removeAt(rowsArrayList.size − 1)
            val scrollPosition = rowsArrayList.size
            recyclerViewAdapter.notifyItemRemoved(scrollPosition)
            var currentSize = scrollPosition
            val nextLimit = currentSize + 10
            while (currentSize − 1 < nextLimit) {
            rowsArrayList.add("Number $currentSize")
            currentSize++
        }
            recyclerViewAdapter.notifyDataSetChanged()
            isLoading = false
        }, 2000)
    }
}