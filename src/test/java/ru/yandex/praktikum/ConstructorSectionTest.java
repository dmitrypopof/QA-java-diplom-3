package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.MainPageConstructorSectionStellar;
import ru.yandex.praktikum.model.MainPageRegistrationStellar;

public class ConstructorSectionTest extends BaseTest {
    @Before
    public void setUp() {
        super.setUp();
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        page.open();
    }

    @Test
    @DisplayName("Проверка перехода раздела Соусы в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionSauce() {
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionSauce();
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Начинки в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionFiling() {
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorFiling();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionFiling();
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Булки в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionBun() {
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        pageSection.selectSectionConstructorBun();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionBun();
        Assert.assertEquals(excepted, actual);
    }
}
