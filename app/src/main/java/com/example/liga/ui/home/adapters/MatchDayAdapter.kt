package com.example.liga.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.liga.R
import com.example.liga.data.local.models.MatchesDaoModel

class MatchDayAdapter: RecyclerView.Adapter<MatchDayAdapter.MatchDayHolder>() {

    class MatchDayHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object: DiffUtil.ItemCallback<MatchesDaoModel>(){
        override fun areItemsTheSame(oldItem: MatchesDaoModel, newItem: MatchesDaoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MatchesDaoModel,
            newItem: MatchesDaoModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchDayHolder(view)
    }

    override fun onBindViewHolder(holder: MatchDayHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }
}