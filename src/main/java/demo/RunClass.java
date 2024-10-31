package demo;

import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class RunClass {

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        ProductsPage pp;
        ConfigProperties cp = new ConfigProperties();
        BrowserDriverManager browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(cp);
        driver.manage().window().maximize();
        browserDriverManager.launchApp(driver, cp);
        LoginPage lp = new LoginPage(driver);
        System.out.println(lp.getLogoText());
        System.out.println(lp.getCurrentUrl());
        System.out.println(lp.getPageTitle());
        pp = lp.login("standard_user", "secret_sauce");
        System.out.println(pp.getProdTitle());
        Thread.sleep(5000);
        pp.clickMenu();
        Thread.sleep(5000);
        pp.clickLogOut();
        Thread.sleep(5000);
        browserDriverManager.closeDriver();
    }
}
