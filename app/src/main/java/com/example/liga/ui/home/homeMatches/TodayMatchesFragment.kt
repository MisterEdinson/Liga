package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.databinding.FragmentTodayMatchesBinding
import com.example.liga.ui.home.HomeViewModel
import com.example.liga.ui.home.adapters.MatchDayAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodayMatchesFragment : Fragment() {

    val viewModel: HomeViewModel by activityViewModels()
    var adapter: MatchDayAdapter? = null
    private lateinit var binding: FragmentTodayMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayMatchesBinding.inflate(layoutInflater)
//        val view = inflater.inflate(R.layout.fragment_today_matches, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.getMatchDay()
        viewModel.matchDayLiveData.observe(viewLifecycleOwner) {
            adapter?.list?.submitList(it)
            binding.pbMatchToDay.visibility = View.INVISIBLE
            if (it.isEmpty()) {
                binding.tvTodayMatchesNone.visibility = View.VISIBLE
            } else {
                binding.tvTodayMatchesNone.visibility = View.GONE
            }
        }
        binding.rvHomeDayMatch.setOnTouchListener(object : SwipeHome(view.context) {
            override fun onSwipeRight() {
                findNavController().navigate(R.id.action_todayMatchesFragment_to_immediateMatchesFragment)
                Toast.makeText(
                    context,
                    "Matches for the coming days",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        binding.tvLabelMatchDayHome.setOnClickListener {
            val bundle = bundleOf("code" to 4289)
            findNavController().navigate(R.id.action_homeFragmentHab_to_teamFragment, bundle)
        }
    }

    private fun initAdapter() {
        adapter = MatchDayAdapter()
        binding.rvHomeDayMatch.adapter = adapter
    }
}

