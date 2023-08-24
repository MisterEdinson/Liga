package com.example.liga.ui.home.adapters

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
import com.example.liga.data.local.models.MatchesModel
import com.example.liga.databinding.ItemMatchBinding
import com.example.liga.domain.utils.TimeConverter

class ImmediateMatchAdapter : RecyclerView.Adapter<ImmediateMatchAdapter.ImmediateHoleder>() {

    private lateinit var binding: ItemMatchBinding

    private val callback = object : DiffUtil.ItemCallback<MatchesModel>() {
        override fun areItemsTheSame(oldItem: MatchesModel, newItem: MatchesModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MatchesModel, newItem: MatchesModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    class ImmediateHoleder(binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImmediateHoleder {
        binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImmediateHoleder(binding)
    }

    override fun onBindViewHolder(holder: ImmediateHoleder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            if (item.crestHomeTeam?.isNotEmpty() == true) {
                binding.imHomeTeam.loadImage(item.crestHomeTeam.toString())
            } else {
                binding.imHomeTeam.loadImage(item.emblemCompetition.toString())
            }
            binding.tvHomeTeam.text = item.nameHomeTeam

            binding.tvStatusMatch.text = item.statusMatch
//            val time = TimeConverter().dateConverterToTime(item.utcDateMatch)

            when (item.statusMatch) {
                "TIMED" -> {
                    binding.tvTotalMatch.text =
                        TimeConverter().getConvertRecycler(item.utcDateMatch)
                }

                "FINISHED" -> binding.tvTotalMatch.text =
                    "${item.fullTimeHomeScore}:${item.fullTimeAwayScore}"

                "POSTPONED" -> {
                    binding.tvTotalMatch.visibility = View.GONE
                    val layoutParam =
                        binding.tvStatusMatch.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParam.topMargin = 0
                    binding.tvStatusMatch.layoutParams
                }
            }

            if (item.crestAwayTeam?.isNotEmpty() == true) {
                binding.imGuestTeam.loadImage(item.crestAwayTeam.toString())
            } else {
                binding.imGuestTeam.loadImage(item.emblemCompetition.toString())
            }
            binding.tvGuestTeam.text = item.nameAwayTeam

            binding.tvHomeTeam.setOnClickListener {
                val bundle = bundleOf("code" to item.idHomeTeam)
                findNavController().navigate(R.id.action_homeFragmentHab_to_teamFragment, bundle)
            }
            binding.tvGuestTeam.setOnClickListener {
                val bundle = bundleOf("code" to item.idAwayTeam)
                findNavController().navigate(R.id.action_homeFragmentHab_to_teamFragment, bundle)
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