plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Si estás en Kotlin 2.x, mantén también:
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.twoscreens"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.twoscreens"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables { useSupportLibrary = true }
    }

    buildFeatures { compose = true }

    // Java/Kotlin a 17
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
kotlin { jvmToolchain(17) }

dependencies {
    // BOM de Compose (gestiona versiones)
    val composeBom = platform("androidx.compose:compose-bom:2024.09.02")
    implementation(composeBom)

    // Núcleo Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")            // ← para verticalScroll/rememberScrollState
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Activity + Compose (para setContent)
    implementation("androidx.activity:activity-compose:1.9.2")

    // Material3 y size classes (para calculateWindowSizeClass)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")

    // Iconos opcionales
    implementation("androidx.compose.material:material-icons-extended")

    // Para el tema XML de tu Manifest
    implementation("com.google.android.material:material:1.12.0")
}
