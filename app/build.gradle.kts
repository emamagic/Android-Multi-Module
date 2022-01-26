plugins {
    id("com.android.application")
    kotlin ("android")
    id("androidx.navigation.safeargs")
    kotlin("kapt")
}

apply {
    from("$rootDir/android-core-build.gradle")
}


android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        multiDexEnabled = true

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

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Modules.network))
    implementation(project(Modules.repositoryImpl))
    implementation(project(Modules.cache))
    implementation(project(Modules.repository))
    implementation(project(Modules.safe))
    implementation(project(Modules.core))
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)


    implementation(project(Modules.home))
    implementation(project(Modules.movies))


    implementation(project(Modules.navigator))


    implementation(Libs.multidex)
    implementation(Libs.dagger)
    kapt(Libs.dagger_kapt)
    implementation(Libs.navigation_component_fragment)
    implementation(Libs.navigation_component_ui)
    implementation(Libs.lottie)
}

kapt {
    correctErrorTypes = true
}