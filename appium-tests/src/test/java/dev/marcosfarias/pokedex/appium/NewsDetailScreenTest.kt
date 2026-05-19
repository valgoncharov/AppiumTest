package dev.marcosfarias.pokedex.appium

import dev.marcosfarias.pokedex.appium.pages.HomePage
import dev.marcosfarias.pokedex.appium.pages.NewsDetailPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тесты для экрана детальной информации о новости
 */
class NewsDetailScreenTest : BaseAppiumTest() {

    private lateinit var homePage: HomePage
    private lateinit var newsDetailPage: NewsDetailPage

    @BeforeEach
    override fun setUp() {
        super.setUp()
        homePage = HomePage(driver)
        newsDetailPage = NewsDetailPage(driver)
        // Переход на экран детальной информации о новости
        homePage.clickViewAll()
        homePage.clickFirstNewsItem()
    }

    @Test
    @DisplayName("Экран детальной информации о новости отображается")
    fun testNewsDetailScreenIsDisplayed() {
        assert(newsDetailPage.isNewsDetailScreenDisplayed()) { "Экран детальной информации должен отображаться" }
    }

    @Test
    @DisplayName("Заголовок новости присутствует")
    fun testNewsTitleIsDisplayed() {
        assert(newsDetailPage.isNewsDetailScreenDisplayed()) { "Заголовок новости должен отображаться" }
    }

    @Test
    @DisplayName("Изображение новости присутствует")
    fun testNewsImageIsDisplayed() {
        assert(newsDetailPage.isNewsImageDisplayed()) { "Изображение новости должно отображаться" }
    }

    @Test
    @DisplayName("Дата новости присутствует")
    fun testNewsDateIsDisplayed() {
        assert(newsDetailPage.isNewsDateDisplayed()) { "Дата новости должна отображаться" }
    }

    @Test
    @DisplayName("Описание новости присутствует")
    fun testNewsDescriptionIsDisplayed() {
        assert(newsDetailPage.isNewsDescriptionDisplayed()) { "Описание новости должно отображаться" }
    }
}