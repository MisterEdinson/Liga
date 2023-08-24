package com.example.liga.ui.cups

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
import com.example.liga.databinding.FragmentCupsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CupsFragment : Fragment() {

    private val viewModel by viewModels<CupsViewModel>()
    private var adapter: CupTableAdapter? = null
    private lateinit var binding: FragmentCupsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCupsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("code") ?: "CL"
        initAdapter()
        viewModel.getCupsInfo(code)
        viewModel.getCupsTable(code)
        viewModel.cupsInfo.observe(viewLifecycleOwner) {
            binding.tvSeasonCup.text = it.season
            binding.tvWinnerCup.text = it.winnerName
            binding.tvStartCup.text = it.seasonStart
            binding.tvEndCup.text = it.seasonEnd
            binding.tvNameCup.text = it.competitionName
            binding.imgLogoCup.loadImage(it.competitionEmblem.toString())
        }
        viewModel.cupsTable.observe(viewLifecycleOwner, Observer {
            adapter?.list?.submitList(it)
        })
        if (code == "CLI") {
            binding.cupsFragment.setBackgroundResource(R.drawable.bg_cup_lib)
        }
    }

    private fun initAdapter() {
        adapter = CupTableAdapter()
        binding.rvCupTable.adapter = adapter
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