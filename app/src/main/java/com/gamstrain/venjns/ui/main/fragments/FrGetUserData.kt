package com.gamstrain.venjns.ui.main.fragments

import NegSlideLeft
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrGetUserDataBinding
import com.google.android.material.datepicker.MaterialDatePicker
import negSlideRight
import slideLeft
import slideRight
import java.sql.Date
import java.util.Locale


class FrGetUserData : Fragment(R.layout.fr_get_user_data) {
    private lateinit var binding: FrGetUserDataBinding
    private var sldPrimaryDt = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrGetUserDataBinding.bind(view)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val prDt = binding.primaryData
        if (sldPrimaryDt) {
            prDt.slideRight(400L, 10L)
        } else {
            prDt.slideLeft(400L, 0L)
        }


        val btEmailV = binding.backToEmailVerify
        btEmailV.rotation = 90f
        btEmailV.setOnClickListener {
            prDt.negSlideRight(400L, 10L)
            fragmentManager.popBackStack()
        }

        //Gender choose
        val genders = listOf("Male", "Female")
        val iGend = ArrayAdapter(requireContext(), R.layout.lay_drop_down_text, genders)
        binding.genders.setAdapter(iGend)

        binding.genders.setDropDownBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.bg_15,
                null
            )
        )
        // choose gender end

        //choose mental state start
        val mentalState =
            listOf("Normal", "Depression", "Anxiety/ Panic attacks", "Not feeling anything")
        val mStateLay = ArrayAdapter(requireContext(), R.layout.lay_drop_down_text, mentalState)
        binding.mentalState.setAdapter(mStateLay)

        binding.mentalState.setDropDownBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.bg_15,
                null
            )
        )

//        binding.mentalState.setOnItemClickListener((parent, view, position, id) -> {
//            String selectedMentalState = (String) parent.getItemAtPosition(position);
//            // Now, you have the selected value in the "selectedMentalState" variable.
//        })
        //choose mental state end


        //date pick start
        val datePickerEditText = binding.DOBpick
        val dateFormat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())

        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select your date of birth")
        val materialDatePicker = builder.build()
        datePickerEditText.setOnClickListener {
            materialDatePicker.show(fragmentManager, "MATERIAL_DATE_PICKER")
        }

        materialDatePicker.addOnPositiveButtonClickListener { selection ->
            val formattedDate = dateFormat.format(Date(selection))
            datePickerEditText.setText(formattedDate)
        }

        //pick DOB end

        binding.subMUd.setOnClickListener() {
            prDt.NegSlideLeft(400L, 0L)
            sldPrimaryDt = false
            fragmentTransaction.replace(R.id.lrF, FrSelectUserName())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}