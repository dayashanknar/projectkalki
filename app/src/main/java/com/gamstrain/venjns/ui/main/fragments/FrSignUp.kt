package com.gamstrain.venjns.ui.main.fragments

import NegSlideLeft
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrSignUpBinding
import negSlideRight
import slideLeft
import slideRight

class FrSignUp : Fragment(R.layout.fr_sign_up) {
    private lateinit var binding: FrSignUpBinding

    private var slideRU = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrSignUpBinding.bind(view)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //globar vars above

        binding.toSignIn.setOnClickListener {
            binding.SignUpFrg.negSlideRight(400L, 10L)
            fragmentManager.popBackStack()
        }

        binding.sendOtpBtn.setOnClickListener {
            binding.SignUpFrg.NegSlideLeft(400L, 0L)
            slideRU = false
            fragmentTransaction.replace(R.id.lrF, FrVerifyEmail())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

//        parent animation
        if (slideRU) {
            binding.SignUpFrg.slideRight(400L, 10L)
        } else {
            binding.SignUpFrg.slideLeft(400L, 0L)
        }


    }
}