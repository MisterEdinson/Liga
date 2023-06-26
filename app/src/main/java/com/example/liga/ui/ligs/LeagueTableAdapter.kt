package com.example.liga.ui.ligs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.network.models.leagueTable.TableItem
import kotlinx.android.synthetic.main.item_league_table.view.*
import kotlinx.android.synthetic.main.item_lig_home.view.*

class LeagueTableAdapter : RecyclerView.Adapter<LeagueTableAdapter.TableViewHolder>() {

    class TableViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<TableItem>(){
        override fun areItemsTheSame(
            oldItem: TableItem,
            newItem: TableItem
        ): Boolean {
            return oldItem.team?.id == newItem.team?.id
        }

        override fun areContentsTheSame(
            oldItem: TableItem,
            newItem: TableItem
        ): Boolean {
            return oldItem.team?.id == newItem.team?.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league_table,parent,false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            imgTeamLeague.loadImage(item.team?.crest.toString())
            tvNameTeamLeague.text = item.team?.name
            tvPositionTeamLeague.text = item.position.toString()
            tvMatchesCountLeague.text = item.playedGames.toString()
            tvPointCountLeague.text = item.points.toString()

            item_id_team.setOnClickListener {
                val bundle = bundleOf("code" to item.team?.id)
                findNavController().navigate(R.id.action_ligsFragment_to_teamFragment,bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    fun ImageView.loadImage(imgUrl: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .placeholder(R.drawable.no_image)
            .error(R.drawable.error)
            .data(imgUrl)
            .target(this)
            .build()
        imageLoader.enqueue(request)
    }
}