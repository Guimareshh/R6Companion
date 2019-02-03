
object Versions {

    /*** Kotlin ***/
    const val kotlin = "1.3.71"

    /** App Settings ***/
    const val androidMinSDK = 23
    const val androidCompileSDK = 29
    const val androidTargetSDK = 29
    const val androidVersionCode = 1
    const val androidVersionName = "0.0.1"
    const val androidBuildTools = "29.0.2"

    /*** Android Libraries ***/
    const val androidKtx = "1.2.0"
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    
    /** Testing ***/
    const val jUnit5Version = "5.6.2"
    const val kluent = "1.60"
    const val mockitoKotlin = "2.2.0"
}

object Libraries {

    /*** Kotlin ***/
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    /*** Android Libraries ***/
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktx = "androidx.core:core-ktx:${Versions.androidKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    /** Testing ***/
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val jUnitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.jUnit5Version}"
    const val jUnitParams = "org.junit.jupiter:junit-jupiter-params:${Versions.jUnit5Version}"
    const val jUnitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5Version}"
 }
