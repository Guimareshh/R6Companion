import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("jvm")
    id("kotlin-kapt")
}

dependencies {
    /*** Kotlin ***/
    api(Libraries.kotlinStdlib)

    /*** DI ***/
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** API Libraries ***/
    api(Libraries.retrofit)
    api(Libraries.moshi)
    api(Libraries.moshiConverter)
    kapt(Libraries.moshiCodegen)
}
