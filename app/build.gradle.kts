import com.android.testing.utils.isTvOrAutoDevice

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.kotlinfinalproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlinfinalproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String","RECIPE_API_BASE_URL", "\"https://api.edamam.com/\"")
            buildConfigField("String","RECIPE_API_APP_ID", "\"237b9e15\"")
            buildConfigField("String","RECIPE_API_APP_KEY", "\"f19a85c6f9416cbe34b86cf0c8cf5f69\"")
            buildConfigField("String","USER_FAKER_API", "\"https://fakerapi.it/api/v1//\"")
        }
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String","RECIPE_API_BASE_URL", "\"https://api.edamam.com/\"")
            buildConfigField("String","RECIPE_API_APP_ID", "\"237b9e15\"")
            buildConfigField("String","RECIPE_API_APP_KEY", "\"f19a85c6f9416cbe34b86cf0c8cf5f69\"")
            buildConfigField("String","USER_FAKER_API", "\"https://fakerapi.it/api/v1//\"")
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
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.room:room-common:2.6.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")


    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // RxKotlin
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.1")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")
    // Koin DI
    implementation("io.insert-koin:koin-core:3.5.0")
    implementation("io.insert-koin:koin-android:3.5.0")

    // Retrofit http client (for interfacing with kotlin data classes)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp client
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Json serializer/deserializer
    implementation("com.google.code.gson:gson:2.10") // Serialization to and from JSON

    // CardView widget
    implementation("androidx.cardview:cardview:1.0.0")
}