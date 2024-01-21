package com.gamstrain.venjns.ui.main.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.gamstrain.venjns.R
import com.gamstrain.venjns.databinding.FrTermsSignUpBinding

class FrTermsSignUp : Fragment(R.layout.fr_terms_sign_up) {
    private lateinit var binding: FrTermsSignUpBinding

    //    private var sldPrimaryDt = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrTermsSignUpBinding.bind(view)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val btPrDt = binding.backToChUnm
        btPrDt.rotation = 90f
        btPrDt.setOnClickListener {
//            btPrDt.negSlideRight(400L, 10L)
            fragmentManager.popBackStack()
        }

        val termsPC = binding.agTermsP
        val termsP =
            "<p>link in paragraph like <a href='https://example.com'>link</a>, so how to do it in Android<br/><br/> this is data</p>"

        // Set the HTML-formatted text to the TextView
        termsPC.text = Html.fromHtml(termsP, Html.FROM_HTML_MODE_LEGACY);

        // Make sure links are clickable
        termsPC.movementMethod = LinkMovementMethod.getInstance()


        binding.agTermsH.setOnClickListener {
            // Define the URL you want to open
            val url = "https://www.example.com"

            // Create an Intent to open the URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            // Start the activity with the Intent
            startActivity(intent)
        }

//        binding.chUnmNxt.setOnClickListener {
//            // Create an intent to start WebViewActivity
//            val intent = Intent(requireActivity(), webView::class.java)
//            intent.putExtra("url", "https://www.hdtube.porn/search/white+round+ass/") // Pass the URL you want to load
//            startActivity(intent)
//        }


    }
}