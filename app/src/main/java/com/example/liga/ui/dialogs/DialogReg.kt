package com.example.liga.ui.dialogs

import android.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.example.liga.databinding.DialogRegBinding
import com.example.liga.domain.utils.AuthProfile
import com.example.liga.ui.home.HomeFragment

class DialogReg(private val fragment: HomeFragment) {
    private val authProfile = AuthProfile(fragment)
    fun createDialog(){
        val buildDialog = AlertDialog.Builder(fragment.context)
        val dialogElement = DialogRegBinding.inflate(fragment.layoutInflater)
        val view = dialogElement.root
        buildDialog.setView(view)

        dialogElement.btnDialogReg.setOnClickListener {
            val email = dialogElement.etDialogEmail.text.toString().trim()
            val pass = dialogElement.etDialogPass.text.toString().trim()
            if(email != null && pass != null){
                Log.e("registration", dialogElement.etDialogEmail.text.toString())
                authProfile.registration(email, pass)
            }else{
                Toast.makeText(fragment.context, dialogElement.etDialogEmail.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        dialogElement.btnDialogSign.setOnClickListener {
            Toast.makeText(fragment.context, "Sign", Toast.LENGTH_SHORT).show()
        }

        buildDialog.show()
    }
}