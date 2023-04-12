package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPageDeleteStellar;
import ru.yandex.praktikum.model.MainPageLoginStellar;
import ru.yandex.praktikum.model.MainPageRegistrationStellar;
import ru.yandex.praktikum.model.MainPageUserData;

public class RegistrationWebTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    @DisplayName("Регистрация пользователя - успешная")
    @Description("Успешная регистрация пользователя")
    public void checkSuccessRegistrationPersonalAccountButton() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        MainPageDeleteStellar pageDelete = new MainPageDeleteStellar(driver);

        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(MainPageUserData.NAME);
        page.inputEmailUserRegistration(MainPageUserData.LOGIN);
        page.inputPasswordUserRegistration(MainPageUserData.PASSWORD);
        page.clickButtonRegistrationByFullFolder();
        pageLogin.waitForLoadEntrance();
        boolean actual = driver.findElement(MainPageLoginStellar.TITLE_ENTRANCE).isDisplayed();
        System.out.println(actual);
        Assert.assertTrue(actual);

        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();

        String accessToken = pageDelete.getTokenAccess();
        if (accessToken!= null) {
            pageDelete.deleteUserStellar(accessToken);
        }
        driver.quit();

    }

    @Test
    @DisplayName("Регистрация пользователя - некорректная")
    @Description("Ошибку для некорректного пароля. Минимальный пароль — шесть символов")
    public void checkErrorRegistrationStellar(){
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);

        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(MainPageUserData.NAME);
        page.inputEmailUserRegistration(MainPageUserData.LOGIN);
        page.inputPasswordUserRegistration(MainPageUserData.PASSWORD_ERROR);
        page.clickButtonRegistrationByFullFolder();
        String actual = page.getTextIncorrectPass();
        System.out.println(actual);
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected,actual);
    }

        @After
        @Step("Закрытие браузера")
        public void cleanUp () {
            driver.quit();
        }
}
