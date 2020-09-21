
object ApplicationSettings {

    /** App Settings ***/
    const val androidMinSDK = 23
    const val androidCompileSDK = 29
    const val androidTargetSDK = 29
    const val androidVersionCode = 1
    const val androidVersionName = "0.0.1"
    const val androidBuildTools = "29.0.3"
}

private object LibrariesVersions {

    /*** Gradle ***/
    const val gradleAndroidTools = "4.0.1"
    const val gradleAndroidJUnit5 = "1.6.2.0"

    /*** Kotlin ***/
    const val kotlin = "1.4.0"
    const val kotlinX = "1.3.9"

    /*** Android Libraries ***/
    const val androidKtx = "1.2.0"
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"

    /*** DI ***/
    const val dagger = "2.17"

    /*** API Libraries ***/
    const val retrofit = "2.8.1"
    const val moshi = "1.9.2"

    /** Testing ***/
    const val jUnit5Version = "5.6.2"
    const val kluent = "1.60"
    const val mockitoKotlin = "2.2.0"
}

object Libraries {

    /*** Gradle ***/
    const val gradleAndroidTools = "com.android.tools.build:gradle:${LibrariesVersions.gradleAndroidTools}"
    const val gradleAndroidJUnit5 = "de.mannodermaus.gradle.plugins:android-junit5:${LibrariesVersions.gradleAndroidJUnit5}"

    /*** Kotlin ***/
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibrariesVersions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibrariesVersions.kotlin}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibrariesVersions.kotlinX}"
    /*** Android Libraries ***/
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${LibrariesVersions.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${LibrariesVersions.appCompat}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${LibrariesVersions.appCompat}"

    /*** DI ***/
    const val dagger = "com.google.dagger:dagger:${LibrariesVersions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${LibrariesVersions.dagger}"

    /*** API Libraries ***/
    const val retrofit = "com.squareup.retrofit2:retrofit:${LibrariesVersions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${LibrariesVersions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${LibrariesVersions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${LibrariesVersions.moshi}"

    /** Testing ***/
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${LibrariesVersions.mockitoKotlin}"
    const val kluent = "org.amshove.kluent:kluent:${LibrariesVersions.kluent}"
    const val jUnitApi = "org.junit.jupiter:junit-jupiter-api:${LibrariesVersions.jUnit5Version}"
    const val jUnitEngine = "org.junit.jupiter:junit-jupiter-engine:${LibrariesVersions.jUnit5Version}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibrariesVersions.kotlinX}"

}
