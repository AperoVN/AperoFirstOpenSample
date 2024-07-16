package com.apero.tutorialsdk.sample

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.apero.firstopen.vsltemplate1.VslFOTemplate1Config
import com.apero.firstopen.vsltemplate1.VslFirstOpenSDK
import com.apero.firstopen.vsltemplate1.admanager.NativeOBUtils
import com.apero.firstopen.vsltemplate1.model.VslFOLanguageModel
import com.apero.firstopen.vsltemplate1.splash.VslFOSplashActivity
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

@SuppressLint("CustomSplashScreen")
class SDKSplashActivity : VslFOSplashActivity() {
    private companion object {
        private const val TAG: String = "SDKSplashActivity"
    }

    override fun initTemplate1Config(): VslFOTemplate1Config {
        val splashConfig = VslFOTemplate1Config.SplashConfig(
            banner = listOf(BuildConfig.banner_splash_1, BuildConfig.banner_splash_2),
            interstitialAd = listOf(BuildConfig.inter_splash_1, BuildConfig.inter_splash_2),
        )
        val languageConfig = VslFOTemplate1Config.LanguageConfig(
            layoutId = R.layout.activity_language,
            itemLayoutId = R.layout.item_language,
            nativeAd1 = VslFOTemplate1Config.NativeAdConfig(
                nativeAdIds = listOf(BuildConfig.native_lfo_2, BuildConfig.native_lfo_1),
                layoutId = R.layout.layout_native_medium
            ),
            nativeAd2 = VslFOTemplate1Config.NativeAdConfig(
                nativeAdIds = listOf(
                    BuildConfig.native_lfo_dup_2,
                    BuildConfig.native_lfo_dup_1
                ),
                layoutId = R.layout.layout_native_medium
            ),
            listLanguage = initListLanguage(),
            languageSelected = VslFOLanguageModel(
                R.drawable.ic_en,
                getString(R.string.setting_uk),
                "en"
            )
        )
        val onboardingConfig = VslFOTemplate1Config.OnboardingConfig(
            layoutId = R.layout.activity_onboarding,
            listOnboarding = initListOnboarding()
        )
        return VslFOTemplate1Config(splashConfig, languageConfig, onboardingConfig)
    }

    private fun initListLanguage(): List<VslFOLanguageModel> {
        return listOf(
            VslFOLanguageModel(R.drawable.ic_en, getString(R.string.setting_uk), "en"),
            VslFOLanguageModel(R.drawable.ic_es, getString(R.string.setting_es), "es"),
            VslFOLanguageModel(R.drawable.ic_fr, getString(R.string.setting_fr), "fr"),
            VslFOLanguageModel(R.drawable.ic_hi, getString(R.string.setting_hi), "hi"),
            VslFOLanguageModel(R.drawable.ic_pt, getString(R.string.setting_pt), "pt"),
            VslFOLanguageModel(R.drawable.ic_rs, getString(R.string.setting_rs), "ru")
        )
    }

    private fun initListOnboarding(): List<VslFOTemplate1Config.OnboardingConfig.IOnboardingData> {
        return listOf(
            VslFOTemplate1Config.OnboardingConfig.IOnboardingData.OnboardingContent(
                layoutId = R.layout.fragment_onboarding_1,
                nativeAd = NativeOBUtils.getNativeConfigOBContentByIndex(
                    0,
                    listOf(BuildConfig.native_ob1_2, BuildConfig.native_ob1_1),
                    R.layout.layout_native_medium
                )
            ),
            VslFOTemplate1Config.OnboardingConfig.IOnboardingData.OnboardingContent(
                layoutId = R.layout.fragment_onboarding_2,
                nativeAd = NativeOBUtils.getNativeConfigOBContentByIndex(
                    1,
                    listOf(BuildConfig.native_ob2_2, BuildConfig.native_ob2_1),
                    R.layout.layout_native_medium
                )
            ),
            VslFOTemplate1Config.OnboardingConfig.IOnboardingData.OnboardingAdFullScreen(
                layoutId = R.layout.fragment_on_boarding_full_screen,
                nativeAd = NativeOBUtils.getNativeConfigOBFullScr(
                    listOf(BuildConfig.native_ob_full_scr_2, BuildConfig.native_ob_full_scr_1),
                    R.layout.layout_onboarding_native_fullscreen
                )
            ),
            VslFOTemplate1Config.OnboardingConfig.IOnboardingData.OnboardingContent(
                layoutId = R.layout.fragment_onboarding_4,
                nativeAd = NativeOBUtils.getNativeConfigOBContentByIndex(
                    3,
                    listOf(BuildConfig.native_ob_4_2, BuildConfig.native_ob_4_1),
                    R.layout.layout_native_medium
                )
            )
        )
    }

    override fun nextScreen(context: Context, data: Bundle?) {
        val intent = Intent(context, MainActivity::class.java)
        data?.let {
            Log.d(TAG, "Selected language code: ${data.getString(VslFirstOpenSDK.ARG_KEY_SELECTED_LANGUAGE_CODE)}")
            intent.putExtras(data)
        }
        context.startActivity(intent)
    }

    override fun handleRemoteConfig(remoteConfig: FirebaseRemoteConfig) {

    }

    override fun updateUI(savedInstanceState: Bundle?) {

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_splash
    }
}