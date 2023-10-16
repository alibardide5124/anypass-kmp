@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.anypass.presentation)
}
kotlin {
  sourceSets {
    val commonMain by getting {
      dependencies {
          implementation(projects.core.common)
          implementation(projects.core.validation)
          implementation(projects.features.addnewpassword.addNewPasswordDomain)
      }
    }
  }
}

android {
  namespace = "io.spherelabs.addnewpasswodpresentation"
  compileSdk = 33
  defaultConfig {
      minSdk = 24
  }
}
