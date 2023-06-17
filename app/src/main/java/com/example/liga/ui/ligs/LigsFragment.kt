package com.example.liga.ui.ligs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.liga.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LigsFragment : Fragment() {

    private val viewModel by viewModels<LeagueViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ligs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.infoLeague.observe(viewLifecycleOwner, Observer {
            Log.d("============", it.toString())
        })
    }
}