package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPageUserData {
    private final WebDriver driver;

    public MainPageUserData(WebDriver driver) {
        this.driver = driver;
    }

    public static final String LOGIN = "pda@yandex.ru";
    public static final String PASSWORD ="123qwe";
    public static final String PASSWORD_ERROR ="123";
    public static final String NAME = "pda";
    public static final String URL_DELETE_REQUEST = "https://stellarburgers.nomoreparties.site/api/auth/user";//HTTP-запрос на удаление пользователя



}
