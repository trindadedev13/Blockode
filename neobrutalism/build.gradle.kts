plugins {
  id("com.android.library")
}

android {
  namespace = "dev.trindadedev.neobrutalism"
  compileSdk = 34

  defaultConfig {
    minSdk = 21
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation("androidx.constraintlayout:constraintlayout:2.2.0")
  implementation("com.google.android.material:material:1.13.0-alpha10")
  implementation("androidx.appcompat:appcompat:1.7.0")
}