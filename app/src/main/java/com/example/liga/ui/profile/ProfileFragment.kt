package com.example.liga.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.databinding.FragmentProfileBinding
import com.example.liga.ui.dialogs.DialogOut

class ProfileFragment : Fragment() {
    private val dialog = DialogOut(this)
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnExitProfile.setOnClickListener {
            dialog.createDialog()
        }

        binding.btnProfileBackHome.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment2_to_homeFragmentHab)
        }
    }
}