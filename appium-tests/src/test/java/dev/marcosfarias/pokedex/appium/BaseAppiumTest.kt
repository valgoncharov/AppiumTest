package dev.marcosfarias.pokedex.appium

import io.appium.java_client.AppiumDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import dev.marcosfarias.pokedex.appium.driver.DriverFactory

/**
 * Базовый класс для всех Appium тестов
 * Управляет жизненным циклом драйвера
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseAppiumTest {

    protected lateinit var driver: AppiumDriver

    /**
     * Инициализация драйвера перед всеми тестами
     */
    @BeforeAll
    open fun setUp() {
        driver = DriverFactory.getDriver()
    }

    /**
     * Закрытие драйвера после всех тестов
     */
    @AfterAll
    open fun tearDown() {
        DriverFactory.quitDriver()
    }
}