// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.android.application") version "8.6.0" apply false
  id("com.android.library") version "8.8.2" apply false
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}