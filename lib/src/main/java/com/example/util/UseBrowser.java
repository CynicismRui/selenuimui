package com.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class UseBrowser {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }


    //启动谷歌浏览器

    public WebDriver startChrome(String url)  {

        try {

            System.setProperty("webdriver.chrome.driver", "D:\\workspace\\tests\\src\\driver\\chromedriver.exe");


            driver = new ChromeDriver();

            driver.get(url);

            System.out.println("成功打开谷歌浏览器！");

//	        driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {

            System.out.println("打开谷歌浏览器时出错了"+e);

        }

        return driver;

    }



    //启动火狐浏览器

     WebDriver startFirefox(String url)  {

        try {

            // 默认支持火狐浏览器，能够正常打开，若不能打开火狐，则把下面的火狐的驱动放开
            System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AndroidStudioProjects\\WebUI2\\lib\\src\\main\\java\\com\\example\\driver\\geckodriver.exe");

//                   System.setProperty("webdriver.gecko.driver", "E:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");
            driver = new FirefoxDriver();

            driver.get(url);

            System.out.println("成功打开火狐浏览器！");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Thread.sleep(2000);

        } catch (Exception e) {

            System.out.println("打开火狐浏览器时出错了"+e);

        }

        return driver;

    }



    //启动IE浏览器

    public WebDriver startIE(String url) throws Exception {

        try {

            System.setProperty("webdriver.ie.driver", "D:\\workspace\\tests\\src\\driver\\IEDriverServer.exe");

            driver = new InternetExplorerDriver();

            driver.get(url);

            System.out.println("成功打开IE浏览器！");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {

            System.out.println("打开IE浏览器时出错了"+e);

        }

        return driver;

    }



    //关闭浏览器

    public void tearDownBrowser() throws Exception {

        try {

            Thread.sleep(2000);

            driver.close();

            System.out.println("成功关闭浏览器！");

        } catch (Exception e) {

            System.out.println("关闭浏览器时出错了"+e);

        }



    }

}