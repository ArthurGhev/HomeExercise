plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val appCompileSdk: Int by rootProject.extra
val appMinSdk: Int by rootProject.extra
val appTargetSdk: Int by rootProject.extra

android {

    namespace = "com.app.presentation"
    compileSdk = appCompileSdk
    defaultConfig {
        minSdk = appMinSdk
        targetSdk = appTargetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles.add(File("consumer-rules.pro"))
    }

    buildTypes {
        debug {
            val debugUrl: String by project
            buildConfigField("String", "apiUrl", debugUrl)

            val appVersionCode: Int by rootProject.extra
            buildConfigField("int", "appVersionCode", appVersionCode.toString())
        }
        release {
            val releaseUrl: String by project
            buildConfigField("String", "apiUrl", releaseUrl)

            val appVersionCode: Int by rootProject.extra
            buildConfigField("int", "appVersionCode", appVersionCode.toString())

            isMinifyEnabled  = true
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

//    implementation("androidx.core:core-ktx:1.7.0")
//    implementation("androidx.appcompat:appcompat:1.5.1")
//    implementation("com.google.android.material:material:1.7.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation(project(mapOf("path" to ":base")))
    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")


    // hilt
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")


}