plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

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

    implementation(Libs.navigation_component_fragment)
    implementation(Libs.navigation_component_ui)
    implementation(Libs.androidx_core)
    implementation(Libs.androidx_compat)
    implementation(Libs.material)
    implementation(Libs.constraint_layout)
    testImplementation(Tests.junit_4)
    androidTestImplementation(Tests.androidx_junit)
    androidTestImplementation(Tests.androidx_espresso)

    implementation(project(Modules.signin))
    implementation(project(Modules.signup))
    implementation(project(Modules.intro))
    implementation(project(Modules.workspaceCreate))
    implementation(project(Modules.workspaceSelect))
    implementation(project(Modules.workspaceAddMember))
    implementation(project(Modules.chat))
    implementation(project(Modules.thread))

}
