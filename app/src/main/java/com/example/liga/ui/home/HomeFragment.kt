package com.example.liga.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.databinding.FragmentHomeBinding
import com.example.liga.ui.dialogs.DialogReg
import com.example.liga.ui.home.adapters.LeaguesAdapter
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var adapter: LeaguesAdapter? = null
    private var binding: FragmentHomeBinding? = null
    private val _binding get() = binding!!
    val viewModel: HomeViewModel by activityViewModels()
    private val dialog = DialogReg(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        viewModel.ligsLiveData.observe(viewLifecycleOwner) {
            adapter?.list?.submitList(it)
        }

        btnProfileHome.setOnClickListener{
            if(mAuth.currentUser?.isEmailVerified != null){
                findNavController().navigate(R.id.action_homeFragmentHab_to_profileFragment2)
            }else{
                dialog.createDialog()
            }
        }

    }

    private fun initAdapter() {
        adapter = LeaguesAdapter()
        _binding.rvLeaguesHome.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}