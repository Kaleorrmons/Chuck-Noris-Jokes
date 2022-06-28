package com.example.chucknorisjokes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
class RecyclerViewAdapter internal constructor(private val itemList: List<String>) :
    RecyclerView.Adapter<ViewHolder>() {
    private val viewItemType = 0
    @NonNull
    override fun onCreateViewHolder(
        @NonNull parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return if (viewType == viewItemType) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            ItemViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loading, parent, false)
            LoadingViewHolder(view)
        }
    }
    override fun onBindViewHolder(@NonNull viewHolder: ViewHolder, position: Int) {
        if (viewHolder is ItemViewHolder) {
            populateItemRows(viewHolder, position)
        } else if (viewHolder is LoadingViewHolder) {
            showLoadingView(viewHolder, position)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return viewItemType
    }
    private inner class ItemViewHolder internal constructor(@NonNull itemView: View) :
        ViewHolder(itemView) {
        internal var tvItem: TextView = itemView.findViewById(R.id.textViewItem)
    }
    private class LoadingViewHolder internal constructor(itemView: View) :
        ViewHolder(itemView) {
        var progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    private fun showLoadingView(viewHolder: LoadingViewHolder, position: Int) {}
    private fun populateItemRows(viewHolder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        viewHolder.tvItem.text = item
    }
}