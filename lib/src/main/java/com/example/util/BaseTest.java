package com.example.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    private static String URL;

    private static WebDriver driver;

    static {

        URL = "http://ceshi.ymqt88.com/ceshi/index.php/Merchant/Index/index";
    }

    private UseBrowser useBrowser = new UseBrowser();

    public WebDriver start() {

        try {

//            driver = useBrowser.startChrome(URL);

//            driver = useBrowser.startIE(URL);

            driver = useBrowser.startFirefox(URL);

        } catch (Exception e) {

            System.out.println(e);

        }
        return driver;

    }


    @AfterSuite

    public void end() throws Exception {

        useBrowser.tearDownBrowser();

    }

}
