package com.gamstrain.venjns.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gamstrain.venjns.ui.main.fragments.FrSignIn
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.ActivitySignInUpBinding


class ActivitySignInUp : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignInUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.lrF, FrSignIn())
                commit()
            }
        }

    }
}