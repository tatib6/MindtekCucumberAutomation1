//package steps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pages.EtsyAppHomePage;
//import pages.EtsyAppSearchResultsPage;
//import pages.EtsyTitlePages;
//import utilities.Driver;
//
//import java.util.List;
//import java.util.Locale;
//
//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;
//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;
//
//public class EtsyAppSteps {
//
//    WebDriver driver = Driver.getDriver();
//    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
//    EtsyAppSearchResultsPage appSearchResultsPage = new EtsyAppSearchResultsPage();
//    EtsyTitlePages etsyTitlePages = new EtsyTitlePages();
//
//    @When("user searches hes for {string}")
//    public void user_searches_hes_for(String item) {
//        etsyAppHomePage.searchBox.sendKeys(item + Keys.ENTER);
//
//
//    }
//
//    @Then("user validates search result items name contains keyword {string}")
//    public void user_validates_search_result_items_contains_keyword(String keyword) {
//
//        List<WebElement> myItemList = appSearchResultsPage.listOfItemsTitles;
//
//        for (WebElement element : myItemList) {
//            if (element.getText().contains(keyword)) {
//                System.out.println(element.getText());
//                Assert.assertTrue("Item does not contain " + keyword + "keyword" + element.getText(),
//                        element.getText().toLowerCase().contains(keyword));
//
//            }
//
//        }
//
//
//    }
//
//    @And("user applies price filter {string} dollars")
//    public void userAppliesPriceFilterOverDollars(String filterRange) {
//        appSearchResultsPage.filterBtn.click();
//        if (filterRange.equals("over 1500")) {
//            appSearchResultsPage.filterRadioButtonOver1500.click();
//        } else if (filterRange.equals("under 1500")) {
//            appSearchResultsPage.filterRadioButtonUnder250.click();
//        } else if (filterRange.equals("250 to 750")) {
//            appSearchResultsPage.filterRadioButton250to750.click();
//        } else if (filterRange.equals("500 to 1000")) {
//            appSearchResultsPage.filterRadioButton500to1000.click();
//        }
//        appSearchResultsPage.applyBtn.click();
//    }
//
//    @Then("user validates that item prices are {string} dollars")
//    public void userValidatesThatItemPricesAreOverDollars(String filterRange) throws InterruptedException {
//        if (filterRange.equals("over 1500")) {
//            Thread.sleep(3000);
//            List<WebElement> prices = appSearchResultsPage.listOfItemPrices;
//
//            for (WebElement element : prices) {
//                System.out.println(element.getText());
//                //String = "2,299.00"-->double = 2299.00
//                String priceStr = element.getText().replace(",", "");//"1920.00"
//                double actualPriceDouble = Double.parseDouble(priceStr);//1920.00
//                System.out.println(actualPriceDouble);
//                //double d = filterRange+priceDouble
//                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
//                double expectedPriceDouble = Double.parseDouble(expectedPrice);
//                Assert.assertTrue(actualPriceDouble >= expectedPriceDouble);// 1920.00 >=1500.00
//            }
//
//
//        } else if (filterRange.equals("under 250")) {
//            Thread.sleep(3000);
//            List<WebElement> prices = appSearchResultsPage.listOfItemPrices;
//
//            for (WebElement element : prices) {
//                System.out.println(element.getText());
//                //String = "2,299.00"-->double = 2299.00
//                String priceStr = element.getText().replace(",", "");//"1920.00"
//                double actualPriceDouble = Double.parseDouble(priceStr);//1920.00
//                System.out.println(actualPriceDouble);
//                //double d = filterRange+priceDouble
//                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
//                double expectedPriceDouble = Double.parseDouble(expectedPrice);
//                Assert.assertTrue(actualPriceDouble < expectedPriceDouble);// 1920.00 >=250.00
//            }
//        }else if (filterRange.equals("250 to 750")){
//            Thread.sleep(3000);
//            List<WebElement> prices = appSearchResultsPage.listOfItemPrices;
//            for (WebElement element : prices) {
//                System.out.println(element.getText());
//                //String = "2,299.00"-->double = 2299.00
//                String priceStr = element.getText().replace(",", "");//"1920.00"
//                double actualPriceDouble = Double.parseDouble(priceStr);//1920.00
//                System.out.println(actualPriceDouble);
//                //double d = filterRange+priceDouble
//                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));//250
//                double expectedPriceDouble1 = Double.parseDouble(expectedPrice1);
//                String expectedPrice2 = filterRange.substring(0,filterRange.lastIndexOf(" ")+1);//750
//                double expectedPriceDouble2 = Double.parseDouble(expectedPrice2);
//
//                Assert.assertTrue(actualPriceDouble >= expectedPriceDouble1 && actualPriceDouble<=expectedPriceDouble2);// 1920.00 >=250.00
//            }
//        }else if (filterRange.equals("500 to 1000")){
//            Thread.sleep(3000);
//            List<WebElement> prices = appSearchResultsPage.listOfItemPrices;
//            for (WebElement element : prices) {
//                System.out.println(element.getText());
//                //String = "2,299.00"-->double = 2299.00
//                String priceStr = element.getText().replace(",", "");//"1920.00"
//                double actualPriceDouble = Double.parseDouble(priceStr);//1920.00
//                System.out.println(actualPriceDouble);
//                //double d = filterRange+priceDouble
//                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));//250
//                double expectedPriceDouble1 = Double.parseDouble(expectedPrice1);
//                String expectedPrice2 = filterRange.substring(0,filterRange.lastIndexOf(" ")+1);//750
//                double expectedPriceDouble2 = Double.parseDouble(expectedPrice2);
//
//                Assert.assertTrue(actualPriceDouble >= expectedPriceDouble1 && actualPriceDouble<=expectedPriceDouble2);// 1920.00 >=250.00
//            }
//        }
//    }
//    @When("user clicks on {string} section")
//    public void user_clicks_on_section(String section) {
//        String actualHeader = "";
//        String actualTitle = "";
//        if (section.equals("Jewelry & Accessories")){
//            etsyAppHomePage.jewelryAndAccessories.click();
//        }else if(section.equals("Clothing & Shoes")){
//           etsyTitlePages.csHeader.click();
//        }else if(section.equals("Home & Living")){
//           etsyTitlePages.hlHeader.click();
//        }else if(section.equals("Wedding & Party")){
//            etsyTitlePages.wpHeader.click();
//        }else if(section.equals("Toys & Entertainment")){
//             etsyTitlePages.teHeader.click();
//        }else if(section.equals("Art & Collectibles")){
//            etsyTitlePages.acHeader.click();
//        }else if(section.equals("Craft Supplies & Tools")){
//               etsyTitlePages.cstHeader.click();
//        }else if(section.equals("The Etsy Gift Guide")){
//            etsyTitlePages.csHeader.click();
//
//        }
//
//      Assert.assertEquals(title,actualTitle);
//      Assert.assertEquals(header,actualHeader);
//
//
//    }
//}
