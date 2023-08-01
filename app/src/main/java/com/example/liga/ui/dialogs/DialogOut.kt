package com.example.liga.ui.dialogs

import android.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.databinding.DialogOutBinding
import com.example.liga.ui.home.HomeFragment
import com.example.liga.ui.profile.ProfileFragment

class DialogOut(private val fragment: ProfileFragment) {

    private var alertDialog: AlertDialog? = null

    fun createDialog() {
        val buildDialog = AlertDialog.Builder(fragment.context)
        val dialogElement = DialogOutBinding.inflate(fragment.layoutInflater)
        val view = dialogElement.root
        buildDialog.setView(view)
        alertDialog = buildDialog.create()
        alertDialog?.show()

        dialogElement.btnDialogSignOutYes.setOnClickListener {
            HomeFragment().mAuth.signOut()
            alertDialog?.dismiss()
            fragment.findNavController().navigate(R.id.action_profileFragment2_to_homeFragmentHab)
        }

        dialogElement.btnDialogSignOutNo.setOnClickListener {
            alertDialog?.dismiss()
        }
    }
}