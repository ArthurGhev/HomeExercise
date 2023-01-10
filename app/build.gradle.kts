plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val appCompileSdk: Int by rootProject.extra
val appMinSdk: Int by rootProject.extra
val appTargetSdk: Int by rootProject.extra
val appVersionCode: Int by rootProject.extra
val appVersionName: String by rootProject.extra

android {
    namespace = "com.app.homeexerciseapp"
    compileSdk = appCompileSdk

    defaultConfig {
        applicationId = "com.app.homeexerciseapp"
        minSdk = appMinSdk
        targetSdk = appTargetSdk
        versionCode = appVersionCode
        versionName = appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            val debugUrl: String by project
            buildConfigField("String", "apiUrl", debugUrl)

            applicationIdSuffix = ".debug"
        }
        release {
            val releaseUrl: String by project
            buildConfigField("String", "apiUrl", releaseUrl)

            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "$project.rootDir/tools/proguard-rules.pro")

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":remote")))
    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":presentation")))
    implementation(project(mapOf("path" to ":base")))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // hilt
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    // navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.3")

    // paging
    implementation ("androidx.paging:paging-runtime:3.1.1")
    implementation ("androidx.paging:paging-common:3.1.1")

    // glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.10.0")


}