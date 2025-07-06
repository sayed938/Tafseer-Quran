plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("kotlin-kapt")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.exampletafsyr.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.Material.material)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.androidxJunit)
    androidTestImplementation(Deps.Test.espresso)

    implementation(Deps.AndroidX.lifecycleRuntimeKtx)
    implementation(Deps.AndroidX.activityCompose)
    implementation(platform(Deps.Compose.bom))
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.graphics)
    implementation(Deps.Compose.toolingPreview)
    implementation(Deps.Compose.material3)
    androidTestImplementation(platform(Deps.Compose.bom))
    androidTestImplementation(Deps.Compose.uiTestJunit4)
    debugImplementation(Deps.Compose.tooling)
    debugImplementation(Deps.Compose.uiTestManifest)

    implementation(Deps.AndroidX.lifecycleViewModelKtx)
    implementation(Deps.Hilt.hiltNavigationCompose)

    implementation(Deps.Hilt.hiltAndroid)
    kapt(Deps.Hilt.hiltCompiler)
    kapt(Deps.Hilt.androidxHiltCompiler)
    implementation(Deps.AndroidX.preferenceKtx)
}