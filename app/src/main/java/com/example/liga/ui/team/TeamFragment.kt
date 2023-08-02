package com.example.liga.ui.team

import android.os.Bundle
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
import com.example.liga.data.network.models.teams.SquadItem
import com.example.liga.databinding.FragmentTeamBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment : Fragment() {

    private val viewModel by viewModels<TeamViewModel>()
    private var adapter: TeamInfoAdapter? = null
    private lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idTeam = arguments?.getInt("code") ?: -1
        viewModel.getTeam(idTeam)
        initAdapter()
        viewModel.teamInfo.observe(viewLifecycleOwner, Observer {
            binding.imgLogoTeamFrag.loadImage(it.teamCrest.toString())
            binding.tvTeamName.text = it.teamName
            binding.tvCountryTeam.text = it.areaName
            binding.tvStadiumName.text = it.teamVenue
            val gson = Gson()
            val stringTable = it.teamSquad
            val objectTableArray = gson.fromJson(stringTable, Array<SquadItem>::class.java)
            val objectTableList = objectTableArray.toList()
            adapter?.list?.submitList(objectTableList)
        })
    }

    private fun initAdapter() {
        adapter = TeamInfoAdapter()
        binding.rvTeamFrag.adapter = adapter
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