package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_today_matches.*

@AndroidEntryPoint
class TodayMatchesFragment : Fragment() {

    val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_today_matches, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHomeDayMatch.setOnTouchListener(object : SwipeHome(view.context) {

            override fun onSwipeRight() {
                findNavController().navigate(R.id.action_todayMatchesFragment_to_immediateMatchesFragment)
                Toast.makeText(
                    context,
                    "Матчи на ближайшие дни",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}