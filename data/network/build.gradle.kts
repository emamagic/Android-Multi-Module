plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

dependencies {

    "implementation"(Libs.retrofit)
    "implementation"(Libs.logging_interceptor)
    "implementation"(Libs.moshi)
    "implementation"(Libs.dagger)
    "kapt"(Libs.dagger_kapt)
    "implementation"(project(Modules.safe))

}