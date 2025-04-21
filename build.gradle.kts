android {
    namespace 'com.name'
    compileSdk 34

    defaultConfig {
        applicationId "com.name"
        minSdk 29
        targetSdk 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        externalNativeBuild {
            cmake {
                arguments "-DOPENCV_VERSION_MAJOR=4", "-DOPENCV_FROM_SDK=FALSE", "-DANDROID_STL=c++_shared"
                targets "native_lib"
            }
        }
    }
    ktlint {
        android = true
        ignoreFailures = false
        disabledRules = ["wildcard-imports", "no-wildcard-imports"]
        reporters {
            reporter "plain"
            reporter "checkstyle"
            //reporter "sarif"
            //reporter "html"
        }
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion '1.5.1'
    }
    packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
    }
    externalNativeBuild {
        cmake {
            path 'src/main/cpp/CMakeLists.txt'
        }
    }
    buildFeatures {
        compose true
        prefab true // Enable prefab for OpenCV
    }
}
