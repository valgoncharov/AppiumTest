package dev.marcosfarias.pokedex.appium.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement

/**
 * Page Object для главного экрана (Home)
 */
class HomePage(driver: AppiumDriver) : BasePage(driver) {

    // Заголовок "Pokedex"
    @AndroidFindBy(id = "search_title")
    private lateinit var titleText: WebElement

    // Поле поиска
    @AndroidFindBy(id = "search_text")
    private lateinit var searchText: WebElement

    // RecyclerView с меню
    @AndroidFindBy(id = "recyclerViewMenu")
    private lateinit var menuRecyclerView: WebElement

    // RecyclerView с новостями
    @AndroidFindBy(id = "recyclerViewNews")
    private lateinit var newsRecyclerView: WebElement

    // Заголовок "Pokemon News"
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pokemon News']")
    private lateinit var newsTitle: WebElement

    // Кнопка "View All"
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View All']")
    private lateinit var viewAllButton: WebElement

    // Первая новость в списке - CardView
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='recyclerViewNews']/android.widget.LinearLayout[1]")
    private lateinit var firstNewsItem: WebElement

    /**
     * Проверить, отображается ли главный экран
     */
    fun isHomeScreenDisplayed(): Boolean {
        return isDisplayed(titleText) && isDisplayed(searchText)
    }

    /**
     * Получить текст заголовка
     */
    fun getTitleText(): String {
        return titleText.text
    }

    /**
     * Получить текст поля поиска
     */
    fun getSearchPlaceholder(): String {
        return searchText.text
    }

    /**
     * Нажать на поле поиска
     */
    fun clickSearchBar() {
        searchText.click()
    }

    /**
     * Проверить, отображается ли список меню
     */
    fun isMenuListDisplayed(): Boolean {
        return isDisplayed(menuRecyclerView)
    }

    /**
     * Проверить, отображается ли список новостей
     */
    fun isNewsListDisplayed(): Boolean {
        return isDisplayed(newsRecyclerView)
    }

    /**
     * Нажать на кнопку "View All"
     */
    fun clickViewAll() {
        viewAllButton.click()
    }

    /**
     * Нажать на первую новость в списке
     */
    fun clickFirstNewsItem() {
        firstNewsItem.click()
    }
}