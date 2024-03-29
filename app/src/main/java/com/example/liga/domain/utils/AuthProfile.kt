package com.example.liga.domain.utils

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.liga.R
import com.example.liga.ui.home.HomeFragment
import com.google.firebase.auth.FirebaseUser

class AuthProfile(private val fragment: HomeFragment) {
    fun registration(email: String, pass: String) {
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            fragment.mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    sendVerificationEmail(it.result.user!!)
                } else {
                    Toast.makeText(fragment.context, "registration failed!", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    fun sendVerificationEmail(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(
                    fragment.context,
                    "Send email verification you address!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    fragment.context,
                    "Send email verification error!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun signIn(email: String, pass: String) {
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            fragment.mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    fragment.findNavController()
                        .navigate(R.id.action_homeFragmentHab_to_profileFragment2)
                    Toast.makeText(fragment.context, "Verification Ok!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(fragment.context, "Error verification!", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}