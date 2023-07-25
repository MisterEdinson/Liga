package com.example.liga.ui.dialogs

import android.app.AlertDialog
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.liga.MainActivity
import com.example.liga.databinding.DialogRegBinding

class DialogReg(private val fragment: Fragment) {
    fun createDialog(){
        val buildDialog = AlertDialog.Builder(fragment.context)
        val dialogElement = DialogRegBinding.inflate(fragment.layoutInflater)
        val view = dialogElement.root
        buildDialog.setView(view)
        buildDialog.show()
    }
}