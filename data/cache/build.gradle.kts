plugins {
    id("com.android.library")
    kotlin ("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

dependencies {

    implementation(Libs.room)
    implementation(Libs.room_coroutine)
    kapt(Libs.room_kapt)

}