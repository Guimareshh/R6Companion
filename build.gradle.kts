buildscript {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.fabric.io/public") }
        
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.21")
        classpath("io.fabric.tools:gradle:1.27.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.fabric.io/public") }
    }
}
