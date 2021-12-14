plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
}

apply {
    from("$rootDir/android-common-build.gradle")
}


android {
    defaultConfig {
        applicationId = Android.applicationId
    }
}

dependencies {

    implementation(project(Modules.signin))
    implementation(project(Modules.signup))
    implementation(project(Modules.intro))
    implementation(project(Modules.workspaceCreate))
    implementation(project(Modules.workspaceSelect))
    implementation(project(Modules.workspaceAddMember))
    implementation(project(Modules.chat))
    implementation(project(Modules.thread))
    implementation(project(Modules.navigator))

    implementation (Libs.navigation_component_fragment)
    implementation (Libs.navigation_component_ui)
}