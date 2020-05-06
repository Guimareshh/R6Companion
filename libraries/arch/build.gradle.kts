plugins{
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
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
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutineAndroid)

    /*** Android Libraries ***/
    implementation(Libraries.appCompat)
}
