package com.example.liga.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.liga.databinding.FragmentHomeBinding
import com.example.liga.ui.home.adapters.LeaguesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var adapter: LeaguesAdapter? = null
    private var binding : FragmentHomeBinding? = null
    private val _binding get() = binding!!
    val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.ligsLiveData.observe(viewLifecycleOwner) {
            adapter?.list?.submitList(it)
        }
    }
    private fun initAdapter(){
        adapter = LeaguesAdapter()
        _binding.rvLeaguesHome.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}