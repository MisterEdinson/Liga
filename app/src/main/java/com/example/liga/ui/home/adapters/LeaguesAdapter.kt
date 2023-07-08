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
import coil.load
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.local.models.CompetitonModel
import kotlinx.android.synthetic.main.item_lig_home.view.*

class LeaguesAdapter : RecyclerView.Adapter<LeaguesAdapter.LeaguesViewHolder>() {
    class LeaguesViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<CompetitonModel>() {

        override fun areItemsTheSame(
            oldItem: CompetitonModel,
            newItem: CompetitonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CompetitonModel,
            newItem: CompetitonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lig_home, parent, false)
        return LeaguesViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaguesViewHolder, position: Int) {
        val item = list.currentList[position]
        holder.itemView.apply {
            when(item.idCompetition){
                2013 -> imgLeague.load(R.drawable.brasil)
                2018 -> imgLeague.load(R.drawable.logo_euro)
                else -> {
                    imgLeague.loadImage(item.emblemCompetition.toString())
                }
            }
            imgLeague.setOnClickListener {
                val bundle = bundleOf("code" to item.codeCompetition)
                if(item.typeCompetition == "LEAGUE"){
                    findNavController().navigate(R.id.action_homeFragment_to_ligsFragment, bundle)
                }else{
                    when(item.codeCompetition){
                        "CLI" -> findNavController().navigate(R.id.action_homeFragment_to_cupsFragment, bundle)
                        "CL" -> findNavController().navigate(R.id.action_homeFragment_to_cupsFragment, bundle)
                    }
                }
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