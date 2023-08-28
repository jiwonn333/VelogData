object Dependencies {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
}

object Versions {
    const val GSON = "2.8.6"
    const val CARD_VIEW = "1.0.0"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "3.4.2"
    const val ROOM = "2.5.0"
    const val NAVIGATION = "2.5.3"
    const val GLIDE = "4.12.0" // 4.13.2
    const val LIFECYCLE = "2.4.0"

    // App Level
    const val GRADLE = "4.2.1"
    const val KOTLIN = "1.6.10"

    // AndroidX
    const val APP_COMPAT = "1.4.1"
    const val MATERIAL = "1.5.0"
    const val CONSTRAINT_LAYOUT = "2.1.3"

    // KTX
    const val CORE = "1.7.0"

    // TEST
    const val JUNIT = "1.1.3"

    // Android Test
    const val ESPRESSO_CORE = "3.4.0"

}

object Libraries {
    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
    }

    object Test {
        const val JUNIT = "androidx.test.ext:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    }

    object CardView {
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.CARD_VIEW}"
    }

    object Room {
        const val ROOM = "androidx.room:room-compiler:${Versions.ROOM}"
    }

    object Gson {
        const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    }

    object OkHttp {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    }

    object Lifecycle {
        const val LIFECYCLE_LIVEDATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    }
}