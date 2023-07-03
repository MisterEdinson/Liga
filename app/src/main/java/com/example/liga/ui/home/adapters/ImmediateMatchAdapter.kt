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
import com.example.liga.data.local.models.MatchesAllSave
import com.example.liga.domain.utils.TimeConverter
import kotlinx.android.synthetic.main.item_match.view.*

class ImmediateMatchAdapter : RecyclerView.Adapter<ImmediateMatchAdapter.ImmediateHoleder>() {

    private val callback = object : DiffUtil.ItemCallback<MatchesAllSave>() {
        override fun areItemsTheSame(oldItem: MatchesAllSave, newItem: MatchesAllSave): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MatchesAllSave, newItem: MatchesAllSave): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    class ImmediateHoleder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImmediateHoleder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ImmediateHoleder(view)
    }

    override fun onBindViewHolder(holder: ImmediateHoleder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            if (item.crestHomeTeam?.isNotEmpty() == true) {
                imHomeTeam.loadImage(item.crestHomeTeam.toString())
            } else {
                imHomeTeam.loadImage(item.emblemCompetition.toString())
            }
            tvHomeTeam.text = item.nameHomeTeam

            tvStatusMatch.text = item.statusMatch
            val time = TimeConverter().dateConverterDay(item.utcDateMatch)
            if (item.statusMatch == "TIMED") {
                tvTotalMatch.text = time
            }
            if (item.statusMatch == "FINISHED") {
                tvTotalMatch.text = "${item.fullTimeHomeScore}:${item.fullTimeAwayScore}"
            }

            if (item.crestAwayTeam?.isNotEmpty() == true) {
                imGuestTeam.loadImage(item.crestAwayTeam.toString())
            } else {
                imGuestTeam.loadImage(item.emblemCompetition.toString())
            }
            tvGuestTeam.text = item.nameAwayTeam
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