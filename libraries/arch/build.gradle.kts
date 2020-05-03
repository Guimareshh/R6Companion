plugins{
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {

    compileSdkVersion(ApplicationSettings.androidCompileSDK)
    buildToolsVersion(ApplicationSettings.androidBuildTools)

    defaultConfig {
        versionCode = ApplicationSettings.androidVersionCode
        versionName = ApplicationSettings.androidVersionName
        minSdkVersion(ApplicationSettings.androidMinSDK)
        targetSdkVersion(ApplicationSettings.androidTargetSDK)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    /*** Kotlin ***/
    api(Libraries.kotlinStdlib)

    /*** DI ***/
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** Android Libraries ***/
    api(Libraries.appCompat)
}
