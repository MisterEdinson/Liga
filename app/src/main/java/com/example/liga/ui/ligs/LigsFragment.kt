package com.example.liga.ui.ligs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.network.models.leagueTable.TableItem
import com.example.liga.databinding.FragmentLigsBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LigsFragment : Fragment() {

    private val viewModel by viewModels<LeagueViewModel>()
    private var adapter: LeagueTableAdapter? = null
    private lateinit var binding: FragmentLigsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLigsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("code") ?: "PL"
        initAdapter()
        viewModel.getTableChampionship(code)
        viewModel.getChampionship.observe(viewLifecycleOwner) {
            binding.tvLeagueCountry.text = it.areaName
            binding.imgLeagueLogo.loadImage(it.competitionEmblem.toString())
            binding.imgLeagueFlag.loadImage(it.areaFlag.toString())
            binding.tvLeagueName.text = it.competitionName
            binding.tvLeagueGameDay.text = it.seasonCurrentMatchday.toString()
            binding.tvLeagueStartDate.text = it.seasonStart
            binding.tvLeagueDateEnd.text = it.seasonEnd

            val gson = Gson()
            val stringTable = it.table
            val tableList = gson.fromJson(stringTable, Array<TableItem>::class.java)
            adapter?.list?.submitList(tableList.toList())
        }
    }

    private fun initAdapter() {
        adapter = LeagueTableAdapter()
        binding.rvLeagueTable.adapter = adapter
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