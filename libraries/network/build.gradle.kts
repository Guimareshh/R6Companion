import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("jvm")
    id("kotlin-kapt")
}

dependencies {
    /*** Kotlin ***/
    implementation(Libraries.kotlinStdlib)

    /*** DI ***/
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** API Libraries ***/
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)
    implementation(Libraries.moshiConverter)
}
