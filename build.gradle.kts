buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        
    }
    dependencies {
        classpath(Libraries.gradleAndroidTools)
        classpath(Libraries.kotlinGradlePlugin)
        classpath(Libraries.gradleAndroidJUnit5)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}
