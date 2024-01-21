package com.gamstrain.venjns.ui.main.fragments

import NegSlideLeft
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrSignInBinding
import com.gamstrain.venjns.ui.main.MainActivity
import setStatusBarColor
import slideLeft
import slideRight

class FrSignIn : Fragment(R.layout.fr_sign_in) {

    private lateinit var binding: FrSignInBinding
    private var slideR = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrSignInBinding.bind(view)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //Global vars aboev

        // status & nevigation bar color below
        context?.let { activity?.setStatusBarColor(it.getColor(android.R.color.white)) }
        // status bar color above


        binding.frgtPswd.setOnClickListener {
            binding.signInLayout.NegSlideLeft(400L, 0L)
            slideR = false
            fragmentTransaction.replace(R.id.lrF, FrForgotPswd())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.toSignUp.setOnClickListener {
            binding.signInLayout.NegSlideLeft(400L, 0L)
            slideR = false
            fragmentTransaction.replace(R.id.lrF, FrSignUp())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        if (slideR) {
            binding.signInLayout.slideRight(400L, 100L)
        } else {
            binding.signInLayout.slideLeft(400L, 0L)
        }

//        binding.signInBt.setOnClickListener(){
//            binding.invalidCrd.text = "Invalid Credentials"
//            // Make the TextView visible and take its height
//            binding.invalidCrd.visibility = View.VISIBLE
//        }
        binding.signInBt.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }


    }
}