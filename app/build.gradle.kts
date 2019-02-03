plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Versions.androidCompileSDK)
    buildToolsVersion(Versions.androidBuildTools)
    defaultConfig {
        applicationId = "com.lucienguimaraes.r6squad"
        versionCode = Versions.androidVersionCode
        versionName = Versions.androidVersionName
        minSdkVersion(Versions.androidMinSDK)
        targetSdkVersion(Versions.androidTargetSDK)
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":core"))

    /*** Kotlin ***/
    implementation(Libraries.kotlinStdlib)

    /*** Android Libraries ***/
    implementation(Libraries.ktx)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
}
