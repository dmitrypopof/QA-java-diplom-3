package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPageConstructorSectionStellar;
import ru.yandex.praktikum.model.MainPageRegistrationStellar;

public class ConstructorSectionTest {
    private WebDriver driver;
    @Before
    @DisplayName("Предусловие. Открыть страницу")
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        MainPageRegistrationStellar page = new MainPageRegistrationStellar(driver);
        page.open();
    }

    @Test
    @DisplayName("Проверка перехода раздела Соусы в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionSauce(){
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        Boolean excepted = true;
        Boolean actual = pageSection.checkTitleSauce();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Начинки в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionFiling(){
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorFiling();
        Boolean excepted = true;
        Boolean actual = pageSection.checkTitleBun();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Булки в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionBun(){
        MainPageConstructorSectionStellar pageSection = new MainPageConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        pageSection.selectSectionConstructorBun();
        Boolean excepted = true;
        Boolean actual = pageSection.checkTitleFiling();
        Assert.assertEquals(excepted,actual);
    }

    @After
    @DisplayName("Закрытие страницы")
    public void setEnd(){
        driver.quit();
    }

}
