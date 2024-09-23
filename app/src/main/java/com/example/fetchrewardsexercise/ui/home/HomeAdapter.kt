package com.example.fetchrewardsexercise.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsexercise.R
import timber.log.Timber

class HomeAdapter (
    private val data: List<HiringUIModel>
): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    inner class ViewHolder(hiringItem: View): RecyclerView.ViewHolder(hiringItem){
        val name: TextView = hiringItem.findViewById(R.id.name)
        val listId: TextView = hiringItem.findViewById(R.id.list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        Timber.d(item.name)
        holder.name.text = item.name
        holder.listId.text = holder.itemView.context.resources.getString(R.string.list_id_string, item.listId)
    }
}