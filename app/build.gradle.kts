import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled


plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    "kotlin-kapt"
}

android {
    namespace = "com.example.sunflower"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sunflower"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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

    //뷰페이저 때문에 넣음
    buildFeatures {
        viewBinding = true
        //noinspection DataBindingWithoutKapt
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation(kotlin("script-runtime"))

    //레트로핏 라이버러리 설정
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:retrofit-mock:2.9.0")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.8.1")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("com.github.bumptech.glide:compiler:4.11.0")
}