package com.example.liga.ui.home.homeMatches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liga.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImmediateMatchesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_immediate_matches, container, false)
    }
}