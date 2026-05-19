package dev.marcosfarias.pokedex.appium.config

/**
 * Конфигурация для Appium тестов
 * Содержит параметры подключения к Appium серверу и настройки устройства
 */
object AppiumConfig {
    // Appium Server URL
    const val APPIUM_SERVER_URL = "http://127.0.0.1:4723"

    // Android capabilities
    const val PLATFORM_NAME = "Android"
    const val PLATFORM_VERSION = "14" // Android 14
    const val DEVICE_NAME = "Android Emulator"
    const val APP_PACKAGE = "dev.marcosfarias.pokedex"
    const val APP_ACTIVITY = ".MainActivity"

    // Implicit wait timeout in seconds
    const val IMPLICIT_WAIT_TIMEOUT = 10L

    // Explicit wait timeout in seconds
    const val EXPLICIT_WAIT_TIMEOUT = 15L

    // Command timeout in seconds
    const val COMMAND_TIMEOUT = 300L

    // New command timeout in milliseconds
    const val NEW_COMMAND_TIMEOUT = 60000L

    // No reset
    const val NO_RESET = true

    // Full reset
    const val FULL_RESET = false

    // Automation name
    const val AUTOMATION_NAME = "UiAutomator2"

    // Auto grant permissions
    const val AUTO_GRANT_PERMISSIONS = true
}