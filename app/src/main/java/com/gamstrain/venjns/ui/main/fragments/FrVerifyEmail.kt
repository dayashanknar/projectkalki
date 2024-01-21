package com.gamstrain.venjns.ui.main.fragments

import NegSlideLeft
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrVerifyEmailBinding
import negSlideRight
import slideLeft
import slideRight

class FrVerifyEmail : Fragment(R.layout.fr_verify_email) {
    private lateinit var binding: FrVerifyEmailBinding
    private var slideRVrEm = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrVerifyEmailBinding.bind(view)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val varifyEmailLay = binding.verifyEmailLay

        if (slideRVrEm) {
            varifyEmailLay.slideRight(400L, 10L)
        } else {
            varifyEmailLay.slideLeft(400L, 0L)
        }

        val backbtnF2 = binding.backTosUFrgt
        backbtnF2.rotation = 90f
        backbtnF2.slideLeft(300L, 30L)
        backbtnF2.setOnClickListener {
            varifyEmailLay.negSlideRight(400L, 10L)
            fragmentManager.popBackStack()
        }

        binding.sendOtpBtn.setOnClickListener {
            binding.sendOtpBtn.NegSlideLeft(400L, 0L)
            slideRVrEm = false
            fragmentTransaction.replace(R.id.lrF, FrGetUserData())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}