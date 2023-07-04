package com.example.liga.ui.cups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_cup_group.view.*
import kotlinx.android.synthetic.main.item_cup_table.view.*
import kotlinx.android.synthetic.main.item_league_table.view.*
import kotlinx.android.synthetic.main.item_test.view.*

class CupTableAdapter : RecyclerView.Adapter<CupTableAdapter.CupViewHolder>() {
    class CupViewHolder(view: View) : RecyclerView.ViewHolder(view)

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
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cup_table, parent, false)
        return CupViewHolder(view)
    }

    override fun onBindViewHolder(holder: CupViewHolder, position: Int) {
        val item = list.currentList[position]

        val gson = Gson()
        val stringTable = item.table
        val objectTableArray = gson.fromJson(stringTable, Array<TableItem>::class.java)
        val objectTableList = objectTableArray.toList()

        holder.itemView.apply {
            tvGroupTable.text = item.standingsGroup
            // место для вставки custom view
        }

    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    private fun ImageView.loadImage(imgUrl: String) {
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