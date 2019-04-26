package com.example.pageobj;

import com.example.util.imgcotout.GetCutOut;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPage implements LoginInterface {
    private String name;

    private String pwd;

    private String forLogin;

    public LoginPage() {

        name = "//*[@id=\"exampleInputName2\"]";
        pwd = "//*[@id=\"exampleInputPassword3\"]";
        forLogin = "login-btn";
    }


    @Override
    public void login(WebDriver driver, String username, String password) throws InterruptedException {

        driver.findElement(By.xpath(name)).sendKeys(username);

        driver.findElement(By.xpath(pwd)).sendKeys(password);

        // 点击登录

        driver.findElement(By.className(forLogin)).click();

        new GetCutOut().getInto(driver);

        Thread.sleep(2000);

//	System.out.println(driver.getCurrentUrl());


    }


    @Override
    public boolean isLoginFall(WebDriver driver) {

        boolean flag = false;

        try {

            if (driver.findElement(By.className("zeromodal-title1")).isDisplayed()) {

                flag = true;

            }

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println(e);

        }

        return flag;

    }

    @Override
    public boolean loginStatus(WebDriver driver) throws InterruptedException {

        if (isAlertPresent(driver)) {

            Reporter.log(driver.switchTo().alert().getText());

            System.out.println(driver.switchTo().alert().getText());

            driver.switchTo().alert().accept();

            driver.navigate().refresh();

            return false;

        } else if ((isLoginFall(driver))) {
            String text = driver.findElement(By.className("zeromodal-title1")).getText();
            switch (text) {
                case "请填写账号":
                    Reporter.log("用户名为空！");

                    System.out.println("用户名为空！");

                    driver.navigate().refresh();

                    Thread.sleep(2000);
                    break;
                case "请填写密码":
                    Reporter.log("密码为空！");

                    System.out.println("密码为空！");

                    driver.navigate().refresh();

                    Thread.sleep(2000);
                    break;
                case "账号或密码错误":
                    Reporter.log("密码为空！");

                    System.out.println("密码为空！");

                    driver.navigate().refresh();

                    Thread.sleep(2000);
                    break;

            }

            return false;

        } else {

            Reporter.log("登录成功！");

            System.out.println("登录成功！");

            return true;

        }

    }

    @Override
    public boolean isAlertPresent(WebDriver driver) {

        try {

            driver.switchTo().alert();

            return true;

        } catch (NoAlertPresentException e) {

            return false;

        }

    }

    @Override
    public boolean isLoginPage(WebDriver driver) {

        boolean flag = false;


        try {
            if (driver.findElement(By.className(forLogin)).getAttribute("value").equals("登录")) {

                flag = true;

                return flag;

            }
        } catch (Exception e) {

            System.out.println(e);

            return flag;
        }

        return flag;

    }


}
