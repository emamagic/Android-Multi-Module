plugins {
    id("com.android.library")
    kotlin ("android")
    kotlin("kapt")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

dependencies {

    implementation(project(Modules.commonJvm))
    implementation(project(Modules.safe))
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.gson_converter)
    implementation(Libs.dagger)
    kapt(Libs.dagger_kapt)
    implementation(Libs.kotlin_coroutines)

}