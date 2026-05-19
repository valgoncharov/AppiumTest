package dev.marcosfarias.pokedex.appium

import dev.marcosfarias.pokedex.appium.pages.HomePage
import dev.marcosfarias.pokedex.appium.pages.PokedexPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тесты с ошибочными сценариями (демонстрация падающих тестов)
 * Эти тесты намеренно содержат неверные assertions для демонстрации
 */
class ErrorScenariosTest : BaseAppiumTest() {

    private lateinit var homePage: HomePage
    private lateinit var pokedexPage: PokedexPage

    @BeforeEach
    override fun setUp() {
        super.setUp()
        homePage = HomePage(driver)
        pokedexPage = PokedexPage(driver)
    }

    @Test
    @DisplayName("Заголовок должен быть 'Pokedex'")
    fun testCorrectTitleExpectedPokedex() {
        // Заголовок на экране - "Pokedex"
        val title = homePage.getTitleText()
        assert(title == "Pokedex") { "Заголовок должен быть 'Pokedex'" }
    }

    @Test
    @DisplayName("ОШИБКА: Placeholder должен содержать 'Find', а не 'Search'")
    fun testWrongSearchPlaceholder() {
        // Этот тест упадет, потому что placeholder содержит "Search", а не "Find"
        val placeholder = homePage.getSearchPlaceholder()
        assert(placeholder.contains("Find")) { "Placeholder должен содержать 'Find'" }
    }

    @Test
    @DisplayName("ОШИБКА: Экран Покедекса не должен отображаться")
    fun testPokedexScreenShouldNotBeDisplayed() {
        // Этот тест упадет, потому что экран отображается
        assert(!pokedexPage.isPokedexScreenDisplayed()) { "Экран Покедекса не должен отображаться" }
    }

    @Test
    @DisplayName("ОШИБКА: Speed Dial не должен отображаться")
    fun testSpeedDialShouldNotBeDisplayed() {
        // Этот тест упадет, потому что Speed Dial отображается
        assert(!pokedexPage.isSpeedDialDisplayed()) { "Speed Dial не должен отображаться" }
    }
}