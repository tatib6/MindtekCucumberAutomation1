package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BrowserUtils {

    /**
     * THis mrthod will accept WebElement of dropdown
     * and String value of dropdown
     * provide value in dropdown
     */
    public static void selectDropdownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
    /**
     * this methods takes screenshots
     * Ex:
     *   takeScreenshot("SauceDemo Test)
     */
    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+testName+".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);

    }

    /**
     * This methos generate randon emails.
     * Ex:
     * getRandomEmail(); -> return testUserEmail647381@gmail.com
     */
    public static String getRandomEmail (){
        String username = "user";
//        Random random = new Random();
//        int number= random.nextInt(999_999);
        UUID uuid=UUID.randomUUID();

        return username+uuid+ "@gmail.com";

    }
    /**
     * This methods generates random strong password
     * Ex:
     *getRandomStrongPassword() -> returns random very strong password
     */
    public static String getRandomStrongPassword(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(getRandomEmail());
//        System.out.println(getRandomStrongPassword());
//    }
}
