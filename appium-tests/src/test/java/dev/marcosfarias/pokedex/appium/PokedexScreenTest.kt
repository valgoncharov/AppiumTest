package dev.marcosfarias.pokedex.appium

import dev.marcosfarias.pokedex.appium.pages.PokedexPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тесты для экрана Покедекса
 */
class PokedexScreenTest : BaseAppiumTest() {

    private lateinit var pokedexPage: PokedexPage

    @BeforeEach
    override fun setUp() {
        super.setUp()
        pokedexPage = PokedexPage(driver)
    }

    @Test
    @DisplayName("Экран Покедекса отображается")
    fun testPokedexScreenIsDisplayed() {
        assert(pokedexPage.isPokedexScreenDisplayed()) { "Экран Покедекса должен отображаться" }
    }

    @Test
    @DisplayName("Speed Dial (FAB) отображается")
    fun testSpeedDialIsDisplayed() {
        assert(pokedexPage.isSpeedDialDisplayed()) { "Speed Dial должен отображаться" }
    }

    @Test
    @DisplayName("Список покемонов отображается")
    fun testPokemonListIsDisplayed() {
        assert(pokedexPage.isPokemonListDisplayed()) { "Список покемонов должен отображаться" }
    }
}