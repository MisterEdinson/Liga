package com.example.liga.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.liga.R
import com.example.liga.data.network.models.teams.SquadItem
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
            tvPositionPlayer.text = positionPlay(item.position.toString())
            tvNamePlayer.text = item.name
            tvBirdtsdayPlayer.text = item.dateOfBirth
            tvCountryPlayer.text = item.nationality
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    fun positionPlay(pos: String): String {
        return when(pos){
            "Goalkeeper" -> "GK"
            "Defence" -> "DF"
            "Midfield" -> "MD"
            "Offence" -> "AT"
            else -> "--"
        }
    }

    class TeamViewHolder(view:View): RecyclerView.ViewHolder(view)
}