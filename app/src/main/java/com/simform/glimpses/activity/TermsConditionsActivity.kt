package com.simform.glimpses.activity

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.databinding.ActivityTermsConditionsBinding
import com.simform.glimpses.helper.Constant

class TermsConditionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTermsConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadWebView()
    }

    /**
     * Load terms and conditions
     */
    private fun loadWebView() {
        binding.apply {
            wvTC.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return false
                }
            }

            wvTC.loadUrl(Constant.urlTC)
        }
    }

}