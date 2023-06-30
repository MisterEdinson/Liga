package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_immediate_matches.*

@AndroidEntryPoint
class ImmediateMatchesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_immediate_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHomeImmediateMatch.setOnTouchListener(object : SwipeHome(view.context) {
            override fun onSwipeLeft() {
                findNavController().navigate(R.id.action_immediateMatchesFragment_to_todayMatchesFragment)
                Toast.makeText(
                    context,
                    "Матчи на сегодня",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}