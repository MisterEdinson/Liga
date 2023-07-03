package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.domain.utils.Constants.Companion.IMMEDIATE_DAY
import com.example.liga.domain.utils.TimeConverter
import com.example.liga.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_immediate_matches.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class ImmediateMatchesFragment : Fragment() {

    private val viewModel : HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val currentDate = Date()
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(currentDate)
        val dayImmediate = TimeConverter().getDayImmediate(currentDate,IMMEDIATE_DAY)

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