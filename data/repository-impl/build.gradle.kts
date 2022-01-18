plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/android-common-build.gradle")
}

dependencies {

    implementation(project(Modules.safe))
    implementation(project(Modules.network))
    implementation(project(Modules.cache))
    implementation(project(Modules.commonJvm))
    implementation(project(Modules.commonEntity))
    implementation(project(Modules.repository))
    implementation(Libs.retrofit)
    implementation(Libs.dagger)
    implementation(Libs.dagger_kapt)
    implementation(Libs.kotlin_reflect)
    implementation(Libs.store_4)

}