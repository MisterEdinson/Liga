package com.example.liga.ui.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.liga.data.network.models.teams.SquadItem
import com.example.liga.databinding.ItemTeamBinding

class TeamInfoAdapter : RecyclerView.Adapter<TeamInfoAdapter.TeamViewHolder>() {
    private lateinit var binding: ItemTeamBinding

    private val callback = object : DiffUtil.ItemCallback<SquadItem>() {
        override fun areItemsTheSame(oldItem: SquadItem, newItem: SquadItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SquadItem, newItem: SquadItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            binding.tvPositionPlayer.text = positionPlay(item.position.toString())
            binding.tvNamePlayer.text = item.name
            binding.tvBirdtsdayPlayer.text = item.dateOfBirth
            binding.tvCountryPlayer.text = item.nationality
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    fun positionPlay(pos: String): String {
        return when (pos) {
            "Goalkeeper" -> "GK"
            "Defence" -> "DF"
            "Midfield" -> "MD"
            "Offence" -> "AT"
            else -> "--"
        }
    }

    class TeamViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root)
}