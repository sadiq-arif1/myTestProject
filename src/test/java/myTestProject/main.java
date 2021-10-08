package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/sadiq/Documents/ChromeWebDriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        Properties prop = ConfigUtils.getProp("data");

        driver.get(prop.getProperty("URL"));

        LoginPage loginPg = new LoginPage(driver);
        loginPg.login();

        //verification
        String text = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
        if(text.contains("Dashboard"))
            System.out.println("User logged In Successfully");

        loginPg.logout();

        //verification
        String url = driver.getCurrentUrl();
        if(url.contains("/login"))
            System.out.println("User logged Out Successfully");
        driver.quit();
    }

}
