plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {

    compileSdkVersion(ApplicationSettings.androidCompileSDK)
    buildToolsVersion(ApplicationSettings.androidBuildTools)

    defaultConfig {
        applicationId = "com.lucienguimaraes.r6squad"
        versionCode = ApplicationSettings.androidVersionCode
        versionName = ApplicationSettings.androidVersionName
        minSdkVersion(ApplicationSettings.androidMinSDK)
        targetSdkVersion(ApplicationSettings.androidTargetSDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs {
        create("release") {
            keyAlias = System.getenv("BITRISEIO_ANDROID_KEYSTORE_ALIAS")
            keyPassword = System.getenv("BITRISEIO_ANDROID_KEYSTORE_PRIVATE_KEY_PASSWORD")
            storeFile = file(System.getenv("BITRISE_SOURCE_DIR") + "/keystores/R6companion.jks")
            storePassword = System.getenv("BITRISEIO_ANDROID_KEYSTORE_PASSWORD")
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":libraries:arch"))
    implementation(project(":libraries:network"))
    implementation(project(":home"))

    /*** Kotlin ***/
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutineAndroid)

    /*** DI ***/
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** Android Libraries ***/
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
}
