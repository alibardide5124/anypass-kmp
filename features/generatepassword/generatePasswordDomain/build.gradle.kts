@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.anypass.domain)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.manager.password)
            }
        }
    }
}

kotlin{
    sourceSets{
        dependencies {
            val androidUnitTest by getting{
                implementation(libs.konsist)
            }
        }
    }
}

android {
    namespace = "io.spherelabs.generatepassworddomain"
    compileSdk = 33
    defaultConfig { minSdk = 24 }
}
