plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/android-common-build.gradle")
}


dependencies {

    implementation(Libs.navigation_component_fragment)
    implementation(Libs.navigation_component_ui)
    implementation(project(Modules.navigator))
    implementation(project(Modules.domain))
    implementation(project(Modules.network))
    implementation(project(Modules.cache))
    implementation(project(Modules.commonEntity))
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.moshi)
    implementation(Libs.dagger)
    kapt(Libs.dagger_kapt)

}
