plugins{
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
    api(project(":libraries:arch"))
    implementation(project(":libraries:network"))

    /*** Kotlin ***/
    api(Libraries.kotlinStdlib)
    api(Libraries.coroutineAndroid)

    /*** DI ***/
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** Android Libraries ***/
    api(Libraries.appCompat)
    api(Libraries.constraintLayout)

    /*** API Libraries ***/
    api(Libraries.retrofit)
    api(Libraries.moshi)
    api(Libraries.moshiConverter)
    kapt(Libraries.moshiCodegen)

    /** Testing ***/
    testApi(Libraries.mockitoKotlin)
    testApi(Libraries.kluent)
    testApi(Libraries.jUnitApi)
}
