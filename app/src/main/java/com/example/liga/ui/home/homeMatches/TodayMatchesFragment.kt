package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.data.network.models.matches.MatchesItem
import com.example.liga.ui.home.HomeViewModel
import com.example.liga.ui.home.adapters.MatchDayAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_today_matches.*

@AndroidEntryPoint
class TodayMatchesFragment : Fragment() {

    val viewModel: HomeViewModel by activityViewModels()
    var adapter: MatchDayAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_today_matches, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.getMatchDay()
        viewModel.matchDayLiveData.observe(viewLifecycleOwner) {
            adapter?.list?.submitList(it)

            if(it.isEmpty()){
                tvTodayMatchesNone.visibility = View.VISIBLE
            }else{
                tvTodayMatchesNone.visibility = View.GONE
            }
        }
        rvHomeDayMatch.setOnTouchListener(object : SwipeHome(view.context) {
            override fun onSwipeRight() {
                findNavController().navigate(R.id.action_todayMatchesFragment_to_immediateMatchesFragment)
                Toast.makeText(
                    context,
                    "Matches for the coming days",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        tvLabelMatchDayHome.setOnClickListener{
            val bundle = bundleOf("code" to 4289)
            findNavController().navigate(R.id.action_homeFragmentHab_to_teamFragment,bundle)
        }
    }

    private fun initAdapter() {
        adapter = MatchDayAdapter()
        rvHomeDayMatch.adapter = adapter
    }
}

