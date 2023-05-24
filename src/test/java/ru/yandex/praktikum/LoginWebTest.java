package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.MainPageDeleteStellar;
import ru.yandex.praktikum.model.MainPageLoginStellar;
import ru.yandex.praktikum.model.MainPageRegistrationStellar;
import ru.yandex.praktikum.model.MainPageUserData;

public class LoginWebTest extends BaseTest {

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
    @DisplayName("Вход по кнопке Войти в аккаунт ")
    @Description("С главной страницы")
    public void loginInAccountMainPage() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        pageLogin.clickButtonEntranceMainPage();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт через личный кабинет ")
    @Description("Вход через личный кабинет")
    public void loginInAccount() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Через форму регистрации, после того как нажать зарегистрировать")
    public void loginThroughFormRegistration() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        pageLogin.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        pageLogin.clickButtonRegAfterPersonalAccount();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Нажать войти -> Восстановить пароль")
    public void loginThroughRecoveryPassword() {
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        pageLogin.clickButtonEntranceMainPage();
        pageLogin.clickResoveryPassword();
        pageLogin.clickEntranceAfterClickRecoveryPassword();
        pageLogin.inputEmailLoginAccount(MainPageUserData.LOGIN);
        pageLogin.inputPasswordLoginAccount(MainPageUserData.PASSWORD);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }
}
