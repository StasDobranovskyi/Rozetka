package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {

    //===============================================Variables==========================================================
    private static final String LINK_GOOGLE = "https://www.google.com/";
    private static final String URL_ROZETKA = "rozetka.com.ua";

    //==============================================Constructor=========================================================
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }
    //================================================Locators==========================================================
    @FindBy(xpath = "//*[@name='q']")
    private WebElement inputGoogle;
    @FindBy(xpath = "(//a[@href='https://rozetka.com.ua/'])[1]")
    private WebElement linkRozetka;

    //================================================Methods===========================================================

    public GoogleHomePage navigateToGoogle() {
        navigate(LINK_GOOGLE);
        return this;
    }

    public GoogleHomePage searchRozetka() {
        inputGoogle.sendKeys(URL_ROZETKA + "\n");
        return this;
    }

    public RozetkaHomePage clickRozetka() {
        linkRozetka.click();
        return new RozetkaHomePage(driver);
    }

    public String getUrlRozetka() {
        return URL_ROZETKA;
    }
}
