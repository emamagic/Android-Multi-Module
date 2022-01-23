plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(Modules.navigator))
    implementation(project(Modules.repository))
    implementation(project(Modules.commonEntity))
    implementation(project(Modules.commonJvm))
    implementation(Libs.navigation_component_fragment)
    implementation(Libs.navigation_component_ui)
    implementation(Libs.dagger)
    implementation(Libs.kotlin_coroutines)
    kapt(Libs.dagger_kapt)

    implementation(Libs.glide)
    kapt(Libs.glide_kapt)
}

kapt {
    correctErrorTypes = true
}
