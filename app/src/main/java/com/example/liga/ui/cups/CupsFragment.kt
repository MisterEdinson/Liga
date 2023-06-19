package com.example.liga.ui.cups

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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cups.*

@AndroidEntryPoint
class CupsFragment : Fragment() {

    private val viewModel by viewModels<CupsViewModel>()
    private var adapter: CupTableAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("code") ?: "CL"
        initAdapter()
        viewModel.getCupsInfo(code)
        viewModel.cupsInfo.observe(viewLifecycleOwner) {
            tvSeasonCup.text = it.season
            tvWinnerCup.text = it.winnerName
            tvStartCup.text = it.seasonStart
            tvEndCup.text = it.seasonEnd
            tvNameCup.text = it.competitionName
            imgLogoCup.loadImage(it.competitionEmblem.toString())
        }
    }
    private fun initAdapter(){
        adapter = CupTableAdapter()
        rvCupTable.adapter = adapter
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