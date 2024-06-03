package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Testinit {
    protected WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterDriver(){
        driver.quit();
    }
}
