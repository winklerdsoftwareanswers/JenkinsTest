package my.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by winklerd on 7/19/2016.
 */
public class JenkinsTest {

    @DataProvider(name = "mySBTest")
    public Object[][] createData(){
       return new Object[][]{
                {"Gary"},
                {"SpongeBob"},
                {"Sandy"}
        };
    }

    @Test(dataProvider = "mySBTest")
    public void method(String mySearch){

        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to Google home page
        driver.get("https://www.bing.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(mySearch);

        // Submit the form (WebDriver will find the form for us from the element)
        element.submit();

        //Wait for results
        // Wait for results to be shown
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains(mySearch));

        //Returns page title(s)
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }

}
