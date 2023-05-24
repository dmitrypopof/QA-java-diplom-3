package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.*;

public class ExitTest extends BaseTest {
    @Before
    @DisplayName("Предусловие. Создать пользователя")
    public void setUp() {
        super.setUp();
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(MainPageUserData.NAME);
        page.inputEmailUserRegistration(MainPageUserData.LOGIN);
        page.inputPasswordUserRegistration(MainPageUserData.PASSWORD);
        page.clickButtonRegistrationByFullFolder();
        pageLogin.waitForLoadEntrance();
        page.transitionMainPage();
    }

    @After
    @DisplayName("Постусловие.Удаление пользователя")
    public void cleanUp() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        MainPageDeleteStellar pageDelete = new MainPageDeleteStellar(driver);
        page.open();
        page.transitionMainPage();
        try {
            page.clickButtonPersonalAccount();
            pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
            pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
            pageLogin.clickLoginInAccount();
        } catch (Exception e) {
        }
        pageLogin.waitForInvisibilityLoadingAnimation();
        String accessToken = pageDelete.getTokenAccess();
        if (accessToken != null) {
            pageDelete.deleteUserStellar(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверить выход по кнопке Выйти в личном кабинете")
    public void checkExitLogin() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        MainPageExitStellar pageExit = new MainPageExitStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();
        page.clickButtonPersonalAccount();
        pageExit.clickExitAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();
        String expected = "Войти";
        String actual = pageExit.getTextButtonEntrance();
        Assert.assertEquals(expected, actual);
    }
}
