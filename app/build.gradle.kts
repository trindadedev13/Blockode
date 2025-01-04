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

  signingConfigs {
    create("release") {
      // temporary keystore
      storeFile = file(layout.buildDirectory.dir("../release_key.jks"))
      storePassword = "release_temp"
      keyAlias = "release_temp"
      keyPassword = "release_temp"
    }
    getByName("debug") {
      storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
      storePassword = "testkey"
      keyAlias = "testkey"
      keyPassword = "testkey"
    }
  }
    
  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
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
  implementation("com.google.code.gson:gson:2.11.0")
}