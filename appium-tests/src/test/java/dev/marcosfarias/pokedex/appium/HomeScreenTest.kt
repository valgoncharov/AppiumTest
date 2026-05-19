package dev.marcosfarias.pokedex.appium

import dev.marcosfarias.pokedex.appium.pages.HomePage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тесты для главного экрана приложения
 */
class HomeScreenTest : BaseAppiumTest() {

    private lateinit var homePage: HomePage

    @BeforeEach
    override fun setUp() {
        super.setUp()
        homePage = HomePage(driver)
    }

    @Test
    @DisplayName("Главный экран отображается корректно")
    fun testHomeScreenIsDisplayed() {
        assert(homePage.isHomeScreenDisplayed()) { "Главный экран должен отображаться" }
    }

    @Test
    @DisplayName("Заголовок Pokedex присутствует")
    fun testPokedexTitleIsDisplayed() {
        val title = homePage.getTitleText()
        assert(title == "Pokedex") { "Заголовок должен быть 'Pokedex'" }
    }

    @Test
    @DisplayName("Placeholder поиска корректный")
    fun testSearchPlaceholder() {
        val placeholder = homePage.getSearchPlaceholder()
        assert(placeholder.contains("Search")) { "Placeholder должен содержать 'Search'" }
    }

    @Test
    @DisplayName("Список меню отображается")
    fun testMenuListIsDisplayed() {
        assert(homePage.isMenuListDisplayed()) { "Список меню должен отображаться" }
    }

    @Test
    @DisplayName("Список новостей отображается")
    fun testNewsListIsDisplayed() {
        assert(homePage.isNewsListDisplayed()) { "Список новостей должен отображаться" }
    }
}