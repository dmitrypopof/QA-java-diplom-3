package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageLoginStellar {
    //поле ввода почты/логина для войти
    private static final By FOLDER_LOG_LOGIN = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(1) > div > div > input");
    // поле ввода пароля для войти
    private static final By FOLDER_LOG_PASSWORD = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(2) > div > div > input");
    //кнопка войти на главной странице
    private static final By BUTTON_ENTRANCE_MAIN_PAGE = By.xpath("//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Войти в аккаунт']");
    //ссылка Восстановить пароль, окно после нажатия на кнопку Войти
    private static final By BUTTON_RECOVERY_PASSWORD = By.xpath("//div/main/div/div/p[2]/a[text()='Восстановить пароль']");
    // кнопка войти при логине:
    private static final By BUTTON_LOG_ACCOUNT = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //кнопка Оформить заказ:
    private static final By BUTTON_PLACE_ON_ORDER = By.xpath("//div/button[text()='Оформить заказ']");
    //кнопка личный кабинет:
    private static final By BUTTON_PERSONAL_ACCOUNT = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/a[@class='AppHeader_header__link__3D_hX']/p[@class='AppHeader_header__linkText__3q_va ml-2']");
    //кнопка войти при регистрации:
    private static final By BUTTON_ENTRANCE_By_REG = By.xpath("//div/main/div/div/p/a[text()='Войти']");
   //ссылка Войти (после клика на сслылку Восстановить пароль
    private static final By LINK_ENTRANCE_AFTER_RECOVERY_CLICK = By.xpath("//div/main/div/div/p/a[text()='Войти']");

    private final WebDriver driver;
    public MainPageLoginStellar(WebDriver driver) {
        this.driver = driver;
    }
    //Надпись Вход:
    public static final By TITLE_ENTRANCE = By.xpath(".//main/div/h2[text()='Вход']");//надпись вход

    @Step("Ожидание до видимости надписи")
    public void waitForLoadEntrance() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(TITLE_ENTRANCE));
    }

    @Step("Ожидание анимации")
    public  void waitForInvisibilityLoadingAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']")));
    }

    @Step("Ввести почту/логин при логине")
    public String  inputEmailLoginAccount(String email){
        driver.findElement(FOLDER_LOG_LOGIN).click();
        driver.findElement(FOLDER_LOG_LOGIN).sendKeys(email);
        return email;
    }

    @Step("Ввести пароль при логине")
    public String  inputPasswordLoginAccount(String email){
        driver.findElement(FOLDER_LOG_PASSWORD).click();
        driver.findElement(FOLDER_LOG_PASSWORD).sendKeys(email);
        return email;
    }

    @Step("Нажать на кнопку войти при логине (окно после нажатия в личный кабинет)")
    public void clickLoginInAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_LOG_ACCOUNT));
        driver.findElement(BUTTON_LOG_ACCOUNT).click();
    }

    @Step("Вход по кнопке Войти в аккаунт на главной")
    public void clickButtonEntranceMainPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_ENTRANCE_MAIN_PAGE));
        driver.findElement(BUTTON_ENTRANCE_MAIN_PAGE).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalAccount(){
        driver.findElement(BUTTON_PERSONAL_ACCOUNT).click();
    }

    @Step("Получение надписи на кнопке - Оформить заказ")
    public String getTextPlaceOnOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_PLACE_ON_ORDER));
        return driver.findElement(BUTTON_PLACE_ON_ORDER).getText();
    }

    @Step("Получение надписи на кнопке - Вход")
    public String getTextEntrance(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(TITLE_ENTRANCE));
                return driver.findElement(TITLE_ENTRANCE).getText();
    }

    @Step("Клик по кнопке войти в окне регистрации")
    public void clickButtonRegAfterPersonalAccount(){
        driver.findElement(BUTTON_ENTRANCE_By_REG).click();
    }

    @Step("Клик по ссылке Восстановить пароль (после клика на кнопку Войти)")
    public void clickResoveryPassword(){
        driver.findElement(BUTTON_RECOVERY_PASSWORD).click();
    }

    @Step("Клик по ссылке Войти (после клика на ссылку Восстановить пароль)")
    public void clickEntranceAfterClickRecoveryPassword(){
        driver.findElement(LINK_ENTRANCE_AFTER_RECOVERY_CLICK).click();
    }

}
