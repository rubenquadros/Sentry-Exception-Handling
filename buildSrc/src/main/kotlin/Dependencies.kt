/**
 * Created by Ruben Quadros on 12/06/22
 **/
object Versions {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "0.0.1"
    const val compose = "1.2.0-beta03"
}

object Dependencies {

    object Compose {
        private const val navigationVersion = "2.4.2"

        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
        const val test = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Hilt {
        private const val version = "2.38.1"
        private const val navigationVersion = "1.0.0"
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:$navigationVersion"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.8.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidJunit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object Sentry {
        const val library = "io.sentry:sentry-android:6.1.1"
    }
}