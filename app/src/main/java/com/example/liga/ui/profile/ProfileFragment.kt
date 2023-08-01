package com.example.liga.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.ui.dialogs.DialogOut
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private val dialog = DialogOut(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnExitProfile.setOnClickListener {
            dialog.createDialog()
        }

        btnProfileBackHome.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment2_to_homeFragmentHab)
        }
    }
}