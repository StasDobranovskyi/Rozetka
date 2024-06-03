package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends BasePage {

    //==============================================Constructor=========================================================
    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    //================================================Locators==========================================================
    @FindBy(xpath = "//div[@class='content padding']")
    private WebElement contentPaddingBlock;
    @FindBy(xpath = "//input[@class='button button--medium popup-content__button button--green ng-star-inserted']")
    private WebElement btnConfirmContentPadding;

    @FindBy(xpath = "//li[contains(@class, 'lang__item lang-header')][1]")
    private WebElement btnUaLanguage;
    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit']")
    private WebElement btnSearch;
    @FindBy(xpath = "//button[@id='fat-menu']")
    private WebElement btnCatalog;
    @FindBy(xpath = "//li[@class='menu-categories__item']/a[contains(text(),'Зоотовари')]")
    private WebElement categoryPetGoods;
    @FindBy(xpath = "//li/a[contains(text(),'Засоби від паразитів')]")
    private WebElement linkMeansAgainstParasites;
    @FindBy(xpath = "//a[@data-id='Rozetka +']")
    private WebElement checkBoxRozetkaPlus;
    @FindBy(xpath = "//a[@data-id='Собаки']")
    private WebElement checkBoxDogs;
    @FindBy(xpath = "//div[@data-filter-name='64077']//input")
    private WebElement searchFieldDestination;
    @FindBy(xpath = "//a[@data-id='Проти бліх та кліщів']")
    private WebElement checkBoxAgainstInsects;
    @FindBy(xpath = "//select[@class='select-css ng-pristine ng-valid ng-star-inserted ng-touched']")
    private WebElement dropDownSorting;
    @FindBy(xpath = "//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private WebElement dropDownMenuOptions;
    @FindBy(xpath = "//option[@class='ng-star-inserted'][contains(text(), 'Від дорогих до дешевих')]")
    private WebElement optionFromExpensiveToCheap;
    @FindBy(xpath = "//div/button[@title='Крупна плитка']")
    private WebElement btnBigIcons;
    @FindBy(xpath = "//span[@class='show-more__text']")
    private WebElement btnViewMoreGoods;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--out_of_stock ng-star-inserted']")
    private WebElement endedGood;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--out_of_stock ng-star-inserted']")
    private WebElement btnCallMe;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--out_of_stock ng-star-inserted']")
    private WebElement popupForm;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--out_of_stock ng-star-inserted']")
    private WebElement inputFieldPhoneNumber;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability--out_of_stock ng-star-inserted']")
    private WebElement btnContinue;

    //================================================Methods===========================================================

    public String getCurrentTitleRozetka() {
        String urlRozetka = "https://" + new GoogleHomePage(driver).getUrlRozetka() + "/";
        return getCurrentTittleSite(urlRozetka);
    }

    public boolean isDisplayedContentPaddingBlock() {
        if (isDisplayedElement(contentPaddingBlock)){
            return true;
        }else {
            return false;
        }
    }

    public RozetkaHomePage clickBtnConfirmContentPadding() {
        moveToElement(waitClickableElement(btnConfirmContentPadding)).click();
        return this;
    }

    public RozetkaHomePage setUaLanguageSite() {
        waitClickableElement(btnUaLanguage).click();
        return this;
    }
    public String getTextBtnSearch() {
      return   waitClickableElement(btnSearch).getText();
    }

    public RozetkaHomePage clickBtnCatalog() {
        moveToElement(waitClickableElement(btnCatalog)).click();
        return this;
    }

    public RozetkaHomePage moveToCategoryPetGoods() {
        waitClickableElement(categoryPetGoods);
        moveToElement(categoryPetGoods);
        return this;
    }

    public RozetkaHomePage clickLinkMeansAgainstParasites() {
        moveToElement(waitClickableElement(linkMeansAgainstParasites)).click();
        return this;
    }

    public RozetkaHomePage selectCheckBoxRozetkaPlus() {
        moveToElement(waitClickableElement(checkBoxRozetkaPlus)).click();
        return this;
    }

    public RozetkaHomePage selectCheckBoxDogs() {
        moveToElement(waitClickableElement(checkBoxDogs)).click();
        return this;
    }

    public RozetkaHomePage sendKeysSearchFieldDestination(String str) {
        moveToElement(waitClickableElement(searchFieldDestination)).sendKeys(str);
        return this;
    }

    public RozetkaHomePage selectCheckBoxAgainstInsects() {
        moveToElement(waitClickableElement(checkBoxAgainstInsects)).click();
        return this;
    }

    public RozetkaHomePage sortFromExpensiveToCheap() {
        moveToElement(waitClickableElement(dropDownMenuOptions)).click();
        waitClickableElement(optionFromExpensiveToCheap).click();
        return this;
    }

    public RozetkaHomePage clickBtnBigIcons() {
        String attributeBtnBigIcons = waitClickableElement(btnBigIcons).getAttribute("class");
        if (attributeBtnBigIcons.contains("active")) {
            moveToElement(btnBigIcons).click();
        } else {
            System.out.println("'Button Big Icons' did not click because this is active");
        }
        return this;
    }

    public RozetkaHomePage clickOnTheEndedGood() {
        boolean isPresentEndedGood = isDisplayedElement(waitClickableElement(endedGood));

        while (isPresentEndedGood) {
            scrollToElement(moveToElement(waitClickableElement(btnViewMoreGoods))).click();
            isPresentEndedGood = isDisplayedElement(waitClickableElement(endedGood));
        }
        moveToElement(waitClickableElement(endedGood)).click();
        return this;
    }

    public RozetkaHomePage clickBtnCallMe() {
        moveToElement(waitClickableElement(btnCallMe)).click();
        return this;
    }

    public RozetkaHomePage inputPhoneNumber(String number) {
        moveToElement(waitClickableElement(inputFieldPhoneNumber)).sendKeys(number);
        return this;
    }

    public RozetkaHomePage clickBtnContinue() {
        moveToElement(waitClickableElement(btnContinue)).click();
        return this;
    }
}




