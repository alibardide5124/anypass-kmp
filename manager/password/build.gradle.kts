plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "password"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
               api(libs.koin.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.coroutine.test)
                implementation(libs.turbine)
            }
        }
    }
}

android {
    namespace = "io.spherelabs.manager.password"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
