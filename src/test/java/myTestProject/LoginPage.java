package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginPage {

    WebDriver driver;
    Properties prop = ConfigUtils.getProp("data");
    By username = new By.ById("txtUsername");
    By password = new By.ByName("txtPassword");
    By loginBtn = new By.ByClassName("button");
    By userSetting = new By.ByXPath("//*[@id='welcome']");
    By logoutBtn = new By.ByLinkText("Logout");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(){
        driver.findElement(username).sendKeys(prop.getProperty("username"));
        driver.findElement(password).sendKeys(prop.getProperty("password"));
        driver.findElement(loginBtn).click();
    }

    public void logout() throws InterruptedException {
        driver.findElement(userSetting).click();
        Thread.sleep(2000);
        driver.findElement(logoutBtn).click();
    }
}
