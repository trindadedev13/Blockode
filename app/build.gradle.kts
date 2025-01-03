plugins {
  id("com.android.application")
}

android {
  namespace = "dev.trindadedev.theblocklogicsjava"
  compileSdk = 33

  defaultConfig {
    applicationId = "dev.trindadedev.theblocklogicsjava"
    minSdk = 21
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
    
    vectorDrawables.useSupportLibrary = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("com.google.android.material:material:1.9.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.github.bumptech.glide:glide:4.16.0")
}