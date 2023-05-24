package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.MainPageLoginStellar;
import ru.yandex.praktikum.model.MainPageRegistrationStellar;
import ru.yandex.praktikum.model.MainPageTransition;

public class TransitionTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        pageLogin.waitForLoadEntrance();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход по клику на Личный кабинет")
    public void transitionByClickPersonalAccount() {
        MainPageLoginStellar pageLogin = new MainPageLoginStellar(driver);
        String expected = "Вход";
        String actual = pageLogin.getTextEntrance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на Конструктор")
    public void transitionOnConstructor() {
        MainPageTransition pageTransition = new MainPageTransition(driver);
        pageTransition.clickTransConstructor();
        String expected = "Соберите бургер";
        String actual = pageTransition.getTextCollectBurger();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета на логотип")
    @Description("Переход по клику на логотип")
    public void transitionOnLogo() {
        MainPageTransition pageTransition = new MainPageTransition(driver);
        pageTransition.clickLogotip();
        String expected = "Соберите бургер";
        String actual = pageTransition.getTextCollectBurger();
        Assert.assertEquals(expected, actual);
    }
}
