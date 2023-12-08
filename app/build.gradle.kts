plugins {
    id("com.android.application")
}

android {
    namespace = "com.tdl.thefashiongateway2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tdl.thefashiongateway2"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs\\mysql-connector-j-8.2.0.jar"))
    implementation(files("libs\\mssql-jdbc-12.4.2.jre8.jar"))
    implementation(files("libs\\jtds-1.3.1.jar"))
    implementation(files("C:\\Users\\LuciaLS\\AndroidStudioProjects\\TheFashionGateway2\\app\\libs\\jtds-1.3.1.jar"))
    implementation(files("C:\\Users\\LuciaLS\\AndroidStudioProjects\\TheFashionGateway2\\app\\libs\\mssql-jdbc-12.4.2.jre8.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}