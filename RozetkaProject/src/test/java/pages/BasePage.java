package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriverWait wait;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    protected void navigate(String link) {
        driver.get(link);
    }

    protected String getCurrentTittleSite(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
        String currentTittle = driver.getTitle();
        return currentTittle;
    }


    protected WebElement moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return element;
    }

    protected WebElement scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    protected WebElement waitClickableElement(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println(element + " isn't clickable within timeout period");
            return null;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println(element + "  isn't founded or isn't in the current DOM");
            return null;
        }
    }


    public boolean isDisplayedElement(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println(element + " isn't clickable within timeout period");
            return false;
        } catch (NoSuchElementException e) {
            System.out.println(element + " isn't founded");
            return false;
        } catch (StaleElementReferenceException e) {
            System.out.println(element + " isn't in the current DOM");
            return false;
        }
    }
}




