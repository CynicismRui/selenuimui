package com.example.test;

import com.example.pageobj.LoginPage;
import com.example.util.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
//必须是static

public class LoginTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    private String LoginURL;

    private WebDriver driver = new BaseTest().start();

    public LoginTest() {

        LoginURL = "http://ceshi.ymqt88.com/ceshi/index.php/Merchant/Index/index";
    }


    /**
     * 方法名称：空的用户名和正确的密码
     * 
     * 方法描述： This method is testing the empty username and the right password
     * 
     * The end is Loginfailed ,I will print some error information  on the console and
     * 
     * the page still stay on the login page
     * 
     * 创建人：zr
     * 
     * 创建时间：2018年4月26日 上午9:41:57
     * 
     * 修改人：zr
     * 
     * 修改时间：2018年4月26日 下午14:44:26
     * 
     * 修改备注：
     *
     * @throws Exception maybe some exception will happen
     * @version 1.0
     */

    //空的用户名和正确的密码，登录失败，控制台输出“用户名为空！”
    @Test(priority = 1)

    public void loginTest1() throws Exception {

        if (!loginPage.isLoginPage(driver)) {

            driver.get(LoginURL);

        }

        try {

            loginPage.login(driver, "f", "123456");

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            assertEquals(false, loginPage.loginStatus(driver));

        }

    }

    /**
     * 方法名称：空的用户名和错误的密码
     *
     * 方法描述： This method is testing the empty username and the right password
     *
     * The end is Loginfailed ,I will print some error information  on the console and
     *
     * the page still stay on the login page
     *
     * 创建人：zr
     *
     * 创建时间：2018年4月26日 上午9:41:57
     *
     * 修改人：zr
     *
     * 修改时间：2018年4月26日 下午14:44:26
     *
     * 修改备注：
     *
     * @throws Exception maybe some exception will happen
     * @version 1.0
     */

    //空的用户名和错误的密码，登录失败，控制台输出“用户名为空！”
    @Test(priority = 2)

    public void loginTest2() throws Exception {

        if (!loginPage.isLoginPage(driver)) {

            driver.get(LoginURL);

        }

        try {

            loginPage.login(driver, "", "789456");

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            assertEquals(false, loginPage.loginStatus(driver));

        }

    }

    /**
     * 方法名称：正确的用户名和空的密码
     *
     * 方法描述： This method is testing the empty username and the right password
     *
     * The end is Loginfailed ,I will print some error information  on the console and
     *
     * the page still stay on the login page
     *
     * 创建人：zr
     *
     * 创建时间：2018年4月26日 上午9:41:57
     *
     * 修改人：zr
     *
     * 修改时间：2018年4月26日 下午14:44:26
     *
     * 修改备注：
     *
     * @throws Exception maybe some exception will happen
     * @version 1.0
     */

    //正确的用户名和空的密码，登录失败，控制台输出“用户名为空！”
    @Test(priority = 3)

    public void loginTest3() throws Exception {

        if (!loginPage.isLoginPage(driver)) {

            driver.get(LoginURL);

        }

        try {

            loginPage.login(driver, "18796079657", "");

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            assertEquals(false, loginPage.loginStatus(driver));

        }

    }
}
