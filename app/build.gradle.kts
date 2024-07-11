plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.gms.services)
}

android {
    namespace = "com.apero.tutorialsdk.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.apero.tutorialsdk.sample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField ("String", "banner_splash_2", "\"ca-app-pub-3940256099942544/6300978111\"")
        buildConfigField ("String", "banner_splash_1", "\"ca-app-pub-3940256099942544/6300978111\"")
        buildConfigField ("String", "inter_splash_2", "\"ca-app-pub-3940256099942544/1033173712\"")
        buildConfigField ("String", "inter_splash_1", "\"ca-app-pub-3940256099942544/8691691433\"")
        buildConfigField ("String", "native_lfo_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_lfo_1", "\"ca-app-pub-3940256099942544/1044960115\"")
        buildConfigField ("String", "native_lfo_dup_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_lfo_dup_1", "\"ca-app-pub-3940256099942544/1044960115\"")
        buildConfigField ("String", "native_ob1_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_ob1_1", "\"ca-app-pub-3940256099942544/1044960115\"")
        buildConfigField ("String", "native_ob2_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_ob2_1", "\"ca-app-pub-3940256099942544/1044960115\"")
        buildConfigField ("String", "native_ob_full_scr_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_ob_full_scr_1", "\"ca-app-pub-3940256099942544/1044960115\"")
        buildConfigField ("String", "native_ob_4_2", "\"ca-app-pub-3940256099942544/2247696110\"")
        buildConfigField ("String", "native_ob_4_1", "\"ca-app-pub-3940256099942544/1044960115\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.apero.tutorial)
    implementation(libs.apero.ads)
    implementation(libs.dotsindicator)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}