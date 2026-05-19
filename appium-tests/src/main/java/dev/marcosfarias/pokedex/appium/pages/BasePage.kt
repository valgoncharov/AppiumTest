package dev.marcosfarias.pokedex.appium.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait
import dev.marcosfarias.pokedex.appium.config.AppiumConfig
import java.time.Duration

/**
 * Базовый класс для всех Page Object
 * Содержит общие методы для работы с элементами
 */
abstract class BasePage(protected val driver: AppiumDriver) {

    init {
        PageFactory.initElements(
            AppiumFieldDecorator(driver, Duration.ofSeconds(AppiumConfig.EXPLICIT_WAIT_TIMEOUT)),
            this
        )
    }

    /**
     * Ожидание элемента
     */
    protected fun waitForElement(timeout: Long = AppiumConfig.EXPLICIT_WAIT_TIMEOUT): WebDriverWait {
        return WebDriverWait(driver, Duration.ofSeconds(timeout))
    }

    /**
     * Проверить, отображается ли элемент
     */
    protected fun isDisplayed(element: org.openqa.selenium.WebElement): Boolean {
        return try {
            element.isDisplayed
        } catch (e: Exception) {
            false
        }
    }
}