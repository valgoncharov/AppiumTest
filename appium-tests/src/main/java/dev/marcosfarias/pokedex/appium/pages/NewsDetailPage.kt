package dev.marcosfarias.pokedex.appium.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement

/**
 * Page Object для экрана детального просмотра новости
 */
class NewsDetailPage(driver: AppiumDriver) : BasePage(driver) {

    // Toolbar
    @AndroidFindBy(id = "toolbar")
    private lateinit var toolbar: WebElement

    // Заголовок новости
    @AndroidFindBy(id = "txtNewsTitle")
    private lateinit var newsTitle: WebElement

    // Изображение новости
    @AndroidFindBy(xpath = "//android.widget.ImageView[1]")
    private lateinit var newsImage: WebElement

    // Дата новости
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '202')]")
    private lateinit var newsDate: WebElement

    // Описание новости (lorem ipsum)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Lorem')]")
    private lateinit var newsDescription: WebElement

    /**
     * Проверить, отображается ли экран детальной информации о новости
     */
    fun isNewsDetailScreenDisplayed(): Boolean {
        return isDisplayed(newsTitle) && isDisplayed(newsImage)
    }

    /**
     * Получить заголовок новости
     */
    fun getNewsTitle(): String {
        return newsTitle.text
    }

    /**
     * Проверить, отображается ли изображение новости
     */
    fun isNewsImageDisplayed(): Boolean {
        return isDisplayed(newsImage)
    }

    /**
     * Проверить, отображается ли дата новости
     */
    fun isNewsDateDisplayed(): Boolean {
        return isDisplayed(newsDate)
    }

    /**
     * Проверить, отображается ли описание новости
     */
    fun isNewsDescriptionDisplayed(): Boolean {
        return isDisplayed(newsDescription)
    }

    /**
     * Нажать на кнопку "назад" в toolbar
     */
    fun clickBackButton() {
        toolbar.findElement(org.openqa.selenium.By.xpath(".//android.widget.ImageButton")).click()
    }
}