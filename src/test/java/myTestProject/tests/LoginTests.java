package myTestProject.tests;

import myTestProject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginTests {

    LoginPage loginPg;
    WebDriver driver;

    @BeforeClass
    public void openPage(){
        System.setProperty("webdriver.chrome.driver", "/home/sadiq/Documents/ChromeWebDriver/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        Properties prop = ConfigUtils.getProp("data");
        driver.get(prop.getProperty("URL"));
    }

    @Test(description = "Login Test", priority = 1)
    public void login(){
        loginPg = new LoginPage(driver);
        loginPg.login();

        //verification
        String text = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
        Assert.assertEquals(text,"Dashboard");
        Assert.assertNotEquals(text,"Dashboard");
        Assert.assertTrue(text.contains("Dashboard"));
    }

    @Test(description = "Logout Test", priority = 2)
    public void logout() throws InterruptedException {
        loginPg.logout();

        //verification
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/login"));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}

//Tutorial : https://bit.ly/3FgtgeF