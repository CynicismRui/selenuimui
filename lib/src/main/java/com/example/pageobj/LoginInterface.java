package com.example.pageobj;

import org.openqa.selenium.WebDriver;

public interface LoginInterface {

    void login(WebDriver driver, String username, String password) throws InterruptedException;

    boolean isLoginFall(WebDriver driver);

    boolean loginStatus(WebDriver driver) throws InterruptedException;

    boolean isAlertPresent(WebDriver driver) ;

    boolean isLoginPage(WebDriver driver);

}
