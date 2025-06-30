// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

}
buildscript {
    dependencies {
        //noinspection UseTomlInstead
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.4")
    }
}