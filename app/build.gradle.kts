buildscript {
    repositories {
        mavenCentral()
    }
}
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.finalproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.finalproject"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation(libs.androidx.navigation.compose)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//    implementation(libs.compose.navigation)
//    implementation(libs.datepickers )
//    implementation ("androidx.compose.material3:material3:1.1.0-alpha04")
//    implementation ("com.marosseleng.android:compose-material3-datetime-pickers:0.6.0")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
//    implementation ("com.github.skydoves:colorpicker-compose:1.0.0")
//    implementation ("me.saket.swipe:swipe:1.0.0")
//    implementation ("androidx.compose.material3:material3:1.0.1")
//    implementation ("io.github.serpro69:kotlin-faker:1.13.0")
//    implementation ("com.github.tehras:charts:0.2.4-alpha")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("io.realm.kotlin:library-base:1.6.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.activity:activity-compose:1.3.1")
    implementation ("androidx.compose.ui:ui:1.3.2")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.2")
    implementation ("androidx.compose.material3:material3:1.0.1")
    implementation ("com.marosseleng.android:compose-material3-datetime-pickers:0.6.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation ("com.github.skydoves:colorpicker-compose:1.0.0")
    implementation ("me.saket.swipe:swipe:1.0.0")
    implementation ("io.github.serpro69:kotlin-faker:1.13.0")
    implementation ("com.github.tehras:charts:0.2.4-alpha")
    implementation ("com.google.accompanist:accompanist-pager:0.29.1-alpha")
    implementation ("io.sentry:sentry-android:6.13.1")
    implementation ("io.sentry:sentry-compose-android:6.13.1")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.3.2")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.3.2")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.3.2")
}
