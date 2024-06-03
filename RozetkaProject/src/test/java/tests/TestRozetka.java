package tests;

import pages.GoogleHomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RozetkaHomePage;

public class TestRozetka extends Testinit {
    String currentTitle;

    @Test
    private void testRozetka() {

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        googleHomePage
                .navigateToGoogle()
                .searchRozetka()
                .clickRozetka();

        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);

        currentTitle = rozetkaHomePage.getCurrentTitleRozetka();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(currentTitle.contains("ROZETKA"));

        if (rozetkaHomePage.isDisplayedContentPaddingBlock()) {
            rozetkaHomePage.clickBtnConfirmContentPadding();

            softAssert.assertFalse(!rozetkaHomePage.isDisplayedContentPaddingBlock());
        }

        if(rozetkaHomePage.getTextBtnSearch().equals("Найти")){
            rozetkaHomePage.setUaLanguageSite();
            softAssert.assertEquals(rozetkaHomePage.getTextBtnSearch(), "Знайти");
        }
        rozetkaHomePage
                .clickBtnCatalog()
                .moveToCategoryPetGoods()
                .clickLinkMeansAgainstParasites()
                .selectCheckBoxRozetkaPlus()
                .selectCheckBoxDogs()
                .sendKeysSearchFieldDestination("проти")
                .selectCheckBoxAgainstInsects()
                .sortFromExpensiveToCheap()
                .clickBtnBigIcons()
                .clickOnTheEndedGood()
                .clickBtnCallMe()
                .inputPhoneNumber("0637846450")
                .clickBtnContinue();

    }
}
