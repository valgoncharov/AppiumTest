plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("io.qameta.allure") version "2.12.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // Appium
    implementation("io.appium:java-client:9.2.2")

    // Selenium
    implementation("org.seleniumhq.selenium:selenium-support:4.27.0")

    // JUnit
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.9")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")
}

tasks.test {
    useJUnitPlatform()
}

allure {
    version.set("2.25.0")
    autoconfigure.set(true)
    attachment.set(true)
    resultsDir.set(file("allure-results"))
    reportDir.set(file("allure-report"))
    cleanResultsDir.set(false)
}
