plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/android-common-build.gradle")
}


dependencies {

    implementation(project(Modules.navigator))
    implementation(project(Modules.domain))
    implementation(project(Modules.commonEntity))
    implementation(project(Modules.commonJvm))
    implementation(Libs.navigation_component_fragment)
    implementation(Libs.navigation_component_ui)
    implementation(Libs.dagger)
    kapt(Libs.dagger_kapt)



}
