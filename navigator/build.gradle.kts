plugins {
    id ("com.android.library")
    id("androidx.navigation.safeargs")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

dependencies {

    implementation (Libs.navigation_component_fragment)
    implementation (Libs.navigation_component_ui)

}