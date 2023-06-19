package com.example.liga.ui.cups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.liga.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CupsFragment : Fragment() {

    private val viewModel by viewModels<CupsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("code") ?: "CL"
        viewModel.getCupsInfo(code)
        viewModel.cupsInfo.observe(viewLifecycleOwner) {

        }
    }
}