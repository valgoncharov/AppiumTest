package dev.marcosfarias.pokedex.appium.driver

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import dev.marcosfarias.pokedex.appium.config.AppiumConfig
import java.net.URL

/**
 * Фабрика для создания и управления Appium драйвером
 */
object DriverFactory {

    private var driver: AppiumDriver? = null

    /**
     * Получить экземпляр Appium драйвера
     * Если драйвер еще не создан, создает новый
     */
    fun getDriver(): AppiumDriver {
        if (driver == null) {
            driver = createDriver()
        }
        return driver!!
    }

    /**
     * Создать новый Appium драйвер
     */
    private fun createDriver(): AppiumDriver {
        val capabilities = UiAutomator2Options()
            .setPlatformName(AppiumConfig.PLATFORM_NAME)
            .setDeviceName(AppiumConfig.DEVICE_NAME)
            .setPlatformVersion(AppiumConfig.PLATFORM_VERSION)
            .setAppPackage(AppiumConfig.APP_PACKAGE)
            .setAppActivity(AppiumConfig.APP_ACTIVITY)
            .setNoReset(AppiumConfig.NO_RESET)
            .setFullReset(AppiumConfig.FULL_RESET)
            .setAutoGrantPermissions(AppiumConfig.AUTO_GRANT_PERMISSIONS)
            .setNewCommandTimeout(java.time.Duration.ofMillis(AppiumConfig.NEW_COMMAND_TIMEOUT))

        val appiumServerUrl = URL(AppiumConfig.APPIUM_SERVER_URL)

        return AndroidDriver(appiumServerUrl, capabilities).apply {
            manage().timeouts().implicitlyWait(
                java.time.Duration.ofSeconds(AppiumConfig.IMPLICIT_WAIT_TIMEOUT)
            )
        }
    }

    /**
     * Закрыть драйвер и освободить ресурсы
     */
    fun quitDriver() {
        driver?.let {
            try {
                it.quit()
            } catch (e: Exception) {
                System.err.println("Error quitting driver: ${e.message}")
            }
        }
        driver = null
    }

    /**
     * Проверить, инициализирован ли драйвер
     */
    fun isDriverInitialized(): Boolean = driver != null
}