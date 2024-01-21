package com.gamstrain.venjns.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrForgotPswdBinding
import negSlideRight
import slideLeft
import slideRight


class FrForgotPswd : Fragment(R.layout.fr_forgot_pswd) {

    private lateinit var binding: FrForgotPswdBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrForgotPswdBinding.bind(view)
        binding.frgtPswdLayout.slideRight(400L, 0L)

        val backbtnF = binding.backBtFrgt
        backbtnF.rotation = 90f
        backbtnF.slideLeft(300L, 300L)

        backbtnF.setOnClickListener {
            binding.frgtPswdLayout.negSlideRight(400L, 100L)
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        }
    }
}