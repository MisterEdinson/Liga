package com.example.liga.ui.home.adapters

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
import com.example.liga.data.local.models.MatchesModel
import com.example.liga.data.network.models.matches.MatchesItem
import com.example.liga.domain.utils.TimeConverter
import kotlinx.android.synthetic.main.item_match.view.*


class MatchDayAdapter : RecyclerView.Adapter<MatchDayAdapter.MatchDayHolder>() {

    class MatchDayHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<MatchesModel>() {
        override fun areItemsTheSame(oldItem: MatchesModel, newItem: MatchesModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MatchesModel,
            newItem: MatchesModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchDayHolder(view)
    }

    override fun onBindViewHolder(holder: MatchDayHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            imHomeTeam.loadImage(item.crestHomeTeam.toString())
            imGuestTeam.loadImage(item.crestAwayTeam.toString())
            tvHomeTeam.text = item.nameHomeTeam
            tvGuestTeam.text = item.nameAwayTeam
            tvStatusMatch.text = item.statusMatch

            val time = TimeConverter().dateConverterToTime(item.utcDateMatch)
            if(item.statusMatch == "TIMED"){
                tvTotalMatch.text = time
            }
            if(item.statusMatch == "FINISHED"){
                tvTotalMatch.text = "${item.fullTimeHomeScore}:${item.fullTimeAwayScore}"
                tvTotalMatch.typeface.isBold
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