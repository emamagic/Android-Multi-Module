plugins {
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    implementation (Libs.java_x)
    implementation (project(Modules.commonEntity))
    implementation (project(Modules.commonJvm))

}
