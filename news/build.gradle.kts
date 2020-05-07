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
    implementation(project(":libraries:arch"))
    implementation(project(":libraries:network"))

    /*** Kotlin ***/
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutineAndroid)

    /*** DI ***/
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** Android Libraries ***/
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation((Libraries.recyclerView))

    /*** API Libraries ***/
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)

    /** Testing ***/
    testImplementation(Libraries.mockitoKotlin)
    testImplementation(Libraries.kluent)
    testImplementation(Libraries.jUnitApi)
    testImplementation(Libraries.coroutineTest)
}
