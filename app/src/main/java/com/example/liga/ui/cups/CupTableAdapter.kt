package com.example.liga.ui.cups

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.example.liga.databinding.ItemCupGroupBinding
import com.example.liga.databinding.ItemCupTableBinding
import com.google.gson.Gson

class CupTableAdapter : RecyclerView.Adapter<CupTableAdapter.CupViewHolder>() {

    private lateinit var binding: ItemCupTableBinding

    class CupViewHolder(binding: ItemCupTableBinding) : RecyclerView.ViewHolder(binding.root)

    val callback = object : DiffUtil.ItemCallback<LeagueChampGsonModel>() {
        override fun areItemsTheSame(
            oldItem: LeagueChampGsonModel,
            newItem: LeagueChampGsonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LeagueChampGsonModel,
            newItem: LeagueChampGsonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CupViewHolder {
        binding = ItemCupTableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CupViewHolder, position: Int) {
        val item = list.currentList[position]

        val gson = Gson()
        val stringTable = item.table
        val objectTableArray = gson.fromJson(stringTable, Array<TableItem>::class.java)
        val objectTableList = objectTableArray.toList()

        holder.itemView.apply {
            binding.tvGroupTable.text = item.standingsGroup
            // место для вставки вложенного recyclerView
            val nestedAdapter = NestedTableAdapter(objectTableList)
            binding.recyclerViewNested.adapter = nestedAdapter
        }

    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }
}

class NestedTableAdapter(
    private val tableList: List<TableItem>
) : RecyclerView.Adapter<NestedTableAdapter.TableViewHolder>() {
    private lateinit var binding: ItemCupGroupBinding

    class TableViewHolder(binding: ItemCupGroupBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        binding = ItemCupGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val tableItem = tableList[position]
        holder.itemView.apply {
            binding.tvPositionTeamTable.text = tableItem.position.toString()
            binding.tvNameTeamTable.text = tableItem.team?.shortName
            binding.imgTeamTable.loadImage(tableItem.team?.crest.toString())
            binding.tvGameCountTeamTable.text = tableItem.playedGames.toString()
            binding.tvPointTeamTable.text = tableItem.points.toString()
            binding.tvGameDrawTeamTable.text = tableItem.draw.toString()
            binding.tvGameLostTeamTable.text = tableItem.lost.toString()
            binding.tvGameWinTeamTable.text = tableItem.won.toString()
        }
    }

    override fun getItemCount(): Int {
        return tableList.size
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
