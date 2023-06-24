package com.example.liga.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.liga.R
import com.example.liga.data.local.models.TeamDaoModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.example.liga.data.network.models.teams.SquadItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_team.view.*

class TeamInfoAdapter:RecyclerView.Adapter<TeamInfoAdapter.TeamViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<SquadItem>(){
        override fun areItemsTheSame(oldItem: SquadItem, newItem: SquadItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SquadItem, newItem: SquadItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            tvPositionPlayer.text = item.position
            tvNamePlayer.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    class TeamViewHolder(view:View): RecyclerView.ViewHolder(view)
}