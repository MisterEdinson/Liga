package com.example.liga.ui.ligs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.network.models.leagueTable.TableItem
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_ligs.*

@AndroidEntryPoint
class LigsFragment : Fragment() {

    private val viewModel by viewModels<LeagueViewModel>()
    private var adapter : LeagueTableAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ligs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("code") ?: "PL"
        initAdapter()
        viewModel.getTableChampionship(code)

        viewModel.getChampionship.observe(viewLifecycleOwner, Observer {
            tvLeagueCountry.text = it.areaName
            imgLeagueLogo.loadImage(it.competitionEmblem.toString())
            imgLeagueFlag.loadImage(it.areaFlag.toString())
            tvLeagueName.text = it.competitionName
            tvLeagueGameDay.text = it.seasonCurrentMatchday.toString()
            tvLeagueStartDate.text = it.seasonStart
            tvLeagueDateEnd.text = it.seasonEnd

            val gson = Gson()
            val stringTable = it.table
            val tableList = gson.fromJson(stringTable, Array<TableItem>::class.java)
            adapter?.list?.submitList(tableList.toList())
        })
    }
    private fun initAdapter(){
        adapter = LeagueTableAdapter()
        rvLeagueTable.adapter = adapter
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