package com.example.liga.ui.cups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.local.models.LeaguesChampionsTableModel

class CupTableAdapter : RecyclerView.Adapter<CupTableAdapter.CupViewHolder>() {
    class CupViewHolder(view: View) : RecyclerView.ViewHolder(view)

    val callback = object : DiffUtil.ItemCallback<LeaguesChampionsTableModel>() {
        override fun areItemsTheSame(
            oldItem: LeaguesChampionsTableModel,
            newItem: LeaguesChampionsTableModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LeaguesChampionsTableModel,
            newItem: LeaguesChampionsTableModel
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
        holder.itemView.apply {

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