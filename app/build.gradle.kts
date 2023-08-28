plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion
    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.example.example"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    implementation(Dependencies.KOTLIN_STDLIB)

    // AndroidX
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    // KTX
    implementation(Libraries.KTX.CORE)

    // TEST
    testImplementation(Libraries.Test.JUNIT)

    // AndroidTest
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)


    implementation(Libraries.CardView.CARD_VIEW)
    implementation(Libraries.Navigation.NAVIGATION_FRAGMENT)
    implementation(Libraries.Navigation.NAVIGATION_UI)
    implementation(Libraries.Glide.GLIDE)
    implementation(Libraries.Glide.GLIDE_COMPILER)
    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.CONVERTER_GSON)
    implementation(Libraries.Gson.GSON)
    implementation(Libraries.OkHttp.OKHTTP)
    implementation(Libraries.OkHttp.LOGGING_INTERCEPTOR)
    implementation(Libraries.Room.ROOM)
    implementation(Libraries.Lifecycle.LIFECYCLE_VIEWMODEL)
    implementation(Libraries.Lifecycle.LIFECYCLE_LIVEDATA)
}

