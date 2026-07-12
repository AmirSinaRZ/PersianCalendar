import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.libray)
    id("maven-publish")
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.amirsinarz.persiancalendar"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        version = "1.1.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
    buildToolsVersion = "37.0.0"
}

kotlin {

    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId="com.github.AmirSinaRZ"
                artifactId="persiancalendar"
                version="1.1.1"
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}