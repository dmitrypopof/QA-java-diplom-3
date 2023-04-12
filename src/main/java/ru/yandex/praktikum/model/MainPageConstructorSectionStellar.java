package ru.yandex.praktikum.model;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageConstructorSectionStellar {
    private final WebDriver driver;

    public MainPageConstructorSectionStellar(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка перехода конструктора в раздел Соусы:
    private static final By BUTTON_TRANS_SAUCE_CONSTRUCTOR = By.xpath("//span[text()='Соусы']");
    //кнопка перехода конструктора в раздел Начинки:
    private static final By BUTTON_TRANS_FILING_CONSTRUCTOR = By.xpath("//span[text()='Начинки']");
    //кнопка перехода конструктора в раздел Булки:
    private static final By BUTTON_TRANS_BUN_CONSTRUCTOR = By.xpath("//span[text()='Булки']");

    //надпись Соусы:
    private static final By TITLE_CONSTRUCTOR_SAUCE = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']");

    //надпись Начинки:
    private static final By TITLE_CONSTRUCTOR_FILING = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']");

    //надпись Булки:
    private static final By TITLE_CONSTRUCTOR_BUN = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']");

    @Step("Выбор раздела Соусы")
    public void selectSectionConstructorSauce(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_SAUCE_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_SAUCE_CONSTRUCTOR).click();
    }

    @Step("Выбор раздела Начинки")
    public void selectSectionConstructorFiling(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_FILING_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_FILING_CONSTRUCTOR).click();
    }

    @Step("Выбор раздела Булки")
    public void selectSectionConstructorBun(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_BUN_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_BUN_CONSTRUCTOR).click();
    }

    @Step("Проверка на видимость надписи Начинки в самом конструкторе")
    public boolean checkTitleFiling(){
        return driver.findElement(TITLE_CONSTRUCTOR_FILING).isDisplayed();
    }

    @Step("Проверка на видимость надписи Соусы в самом конструкторе")
    public boolean checkTitleSauce(){
        return driver.findElement(TITLE_CONSTRUCTOR_SAUCE).isDisplayed();
    }

    @Step("Проверка на видимость надписи Булки в самом конструкторе")
    public boolean checkTitleBun(){
        return driver.findElement(TITLE_CONSTRUCTOR_BUN).isDisplayed();
    }
}
