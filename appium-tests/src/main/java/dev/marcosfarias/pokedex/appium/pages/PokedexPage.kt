package dev.marcosfarias.pokedex.appium.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement

/**
 * Page Object для экрана Покедекс
 */
class PokedexPage(driver: AppiumDriver) : BasePage(driver) {

    // Toolbar с заголовком
    @AndroidFindBy(id = "toolbar")
    private lateinit var toolbar: WebElement

    // RecyclerView со списком покемонов
    @AndroidFindBy(id = "recyclerView")
    private lateinit var pokemonRecyclerView: WebElement

    // ProgressBar (индикатор загрузки)
    @AndroidFindBy(id = "progressBar")
    private lateinit var progressBar: WebElement

    // Speed Dial (FAB с фильтрами)
    @AndroidFindBy(id = "speedDial")
    private lateinit var speedDial: WebElement

    // Заголовок "Pokedex" в toolbar
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pokedex']")
    private lateinit var titleText: WebElement

    /**
     * Проверить, отображается ли экран Покедекса
     */
    fun isPokedexScreenDisplayed(): Boolean {
        return isDisplayed(pokemonRecyclerView)
    }

    /**
     * Получить текст заголовка
     */
    fun getTitleText(): String {
        return titleText.text
    }

    /**
     * Проверить, отображается ли список покемонов
     */
    fun isPokemonListDisplayed(): Boolean {
        return isDisplayed(pokemonRecyclerView)
    }

    /**
     * Проверить, виден ли индикатор загрузки
     */
    fun isProgressBarVisible(): Boolean {
        return try {
            progressBar.isDisplayed
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Нажать на Speed Dial (FAB)
     */
    fun clickSpeedDial() {
        speedDial.click()
    }

    /**
     * Проверить, отображается ли Speed Dial
     */
    fun isSpeedDialDisplayed(): Boolean {
        return isDisplayed(speedDial)
    }

    /**
     * Получить количество видимых покемонов
     */
    fun getPokemonCount(): Int {
        return try {
            val items = pokemonRecyclerView.findElements(
                org.openqa.selenium.By.xpath(".//android.widget.LinearLayout")
            )
            items.size
        } catch (e: Exception) {
            0
        }
    }
}