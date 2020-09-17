plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "me.moallemi.kmmshowcase"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.koinCore)
    implementation(Dependencies.Coroutines.common)
    implementation(Dependencies.Coroutines.android)
}
android {
    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildToolsVersion)
    defaultConfig {
        applicationId = "me.moallemi.kmmshowcase.androidApp"
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = 1
        versionName = "1.0.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        packagingOptions {
            exclude("META-INF/AL2.0")
            exclude("META-INF/LGPL2.1")
            exclude("META-INF/*.kotlin_module")
        }
    }
}