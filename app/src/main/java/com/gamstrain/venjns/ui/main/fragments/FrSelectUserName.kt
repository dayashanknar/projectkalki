package com.gamstrain.venjns.ui.main.fragments

import NegSlideLeft
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrSelectUserNameBinding

class FrSelectUserName : Fragment(R.layout.fr_select_user_name) {
    private lateinit var binding: FrSelectUserNameBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrSelectUserNameBinding.bind(view)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val btPrDt = binding.backToPrimaryDt
        btPrDt.rotation = 90f
        btPrDt.setOnClickListener {
//            btPrDt.negSlideRight(400L, 10L)
            fragmentManager.popBackStack()
        }

        //unique and valid username
        val yourCondition = true // Change this as needed
        val textInputLayout = binding.chUserNmC
        if (yourCondition) {
            // Condition met - set a green checkmark as the end icon
            textInputLayout.endIconDrawable = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_checkmark
            )
            textInputLayout.endIconContentDescription = "Checkmark" // Accessibility description
            textInputLayout.error = null // Clear any previous error message
        } else if (!yourCondition) {

            textInputLayout.error = "username can not have special character (*,&,^,% etc)"
        } else {
            textInputLayout.error = "this username is not available"
        }
        //unique user name above

        binding.chUnmNxt.setOnClickListener() {
            binding.chUnmLay.NegSlideLeft(400L, 0L)
//            sldPrimaryDt = false
            fragmentTransaction.replace(R.id.lrF, FrTermsSignUp())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}