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
import com.example.liga.databinding.FragmentImmediateMatchesBinding
import com.example.liga.ui.home.HomeViewModel
import com.example.liga.ui.home.adapters.ImmediateMatchAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImmediateMatchesFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private var adapter: ImmediateMatchAdapter? = null
    private lateinit var binding: FragmentImmediateMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getImmediateDay()
        //return inflater.inflate(R.layout.fragment_immediate_matches, container, false)
        binding = FragmentImmediateMatchesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.matchImmediateLiveData.observe(viewLifecycleOwner) {
            adapter?.list?.submitList(it)
            if (it.isNotEmpty()) {
                binding.pbMatchImmediate.visibility = View.INVISIBLE
            }
        }

        binding.rvHomeImmediateMatch.setOnTouchListener(object : SwipeHome(view.context) {
            override fun onSwipeLeft() {
                findNavController().navigate(R.id.action_immediateMatchesFragment_to_todayMatchesFragment)
                Toast.makeText(
                    context,
                    "Matches for today",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun initAdapter() {
        adapter = ImmediateMatchAdapter()
        binding.rvHomeImmediateMatch.adapter = adapter
    }
}