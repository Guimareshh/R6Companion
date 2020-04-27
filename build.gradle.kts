buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        
    }
    dependencies {
        classpath(Libraries.gradleAndroidTools)
        classpath(Libraries.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}
