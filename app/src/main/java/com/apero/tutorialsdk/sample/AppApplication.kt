package com.apero.tutorialsdk.sample

import android.app.Application
import com.ads.control.admob.Admob
import com.ads.control.admob.AppOpenManager
import com.ads.control.ads.AperoAd
import com.ads.control.config.AdjustConfig
import com.ads.control.config.AdsConsentConfig
import com.ads.control.config.AperoAdConfig
import com.ads.control.event.AperoAdjust
import com.apero.firstopen.vsltemplate1.VslFirstOpenSDK
import com.google.android.gms.ads.AdActivity
import com.google.firebase.FirebaseApp


class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initAd()
        FirebaseApp.initializeApp(this)
        VslFirstOpenSDK.init(this)
    }

    private fun initAd(): AperoAd {
        val aperoAd: AperoAd = AperoAd.getInstance()
        val environment = AperoAdConfig.ENVIRONMENT_DEVELOP
        val aperoAdConfig = AperoAdConfig(
            this,
            AperoAdConfig.PROVIDER_ADMOB,
            environment
        ).apply {
            apiKey = API_KEY
            adjustConfig = AdjustConfig(ADJUST_ID)
        }
        aperoAd.init(this, aperoAdConfig, false)
        aperoAd.initAdsNetwork()
        return aperoAd
    }

    companion object {
        private const val ADJUST_ID = "ADJUST_ID"
        private const val API_KEY =
            """nSU7IJ740v46YgI7+Q854tSTyet6l4rDvd+66ex27XHg49C4sALwHTvcAGdmJbqsMClJN9piQ6wN8dbBTy02bE4F1CuZCWCsCvzm5hs77d8iMJ5DdFYZyw7HfbcutmH/9x5Y38vhQAo6knjGfvMxCmJx05Q+NHtPLINtHc4nKdg="""
    }
}