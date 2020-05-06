plugins {
    kotlin("jvm")
    id("kotlin-kapt")
}

dependencies {
    /*** Kotlin ***/
    implementation(Libraries.kotlinStdlib)

    /*** DI ***/
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    /*** API Libraries ***/
    api(Libraries.retrofit)
    api(Libraries.moshi)
    implementation(Libraries.moshiConverter)
    kapt(Libraries.moshiCodegen)
}
