package com.gamstrain.venjns.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.ActivityMainBinding
import setStatusBarColor

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var fragmentClassName: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Thread.sleep(5000)
        installSplashScreen()
        setContentView(binding.root)
        setStatusBarColor(getColor(android.R.color.white))
    }
}