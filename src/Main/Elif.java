package Main;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elif extends BaseDriver {
    @Test
    public void loginTest() {
        driver.get("https://openmrs.org/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement demoBtn = driver.findElement(By.id(""));
        demoBtn.click();

       js.executeScript("window.scrollTo(0, 500);");
       MyFunc.Bekle(2);

        WebElement openMsr2 = driver.findElement(By.id(""));
        openMsr2.click();
        MyFunc.Bekle(2);

        WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));//"user-name"
        userName.sendKeys("");

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id(""))); //"password"
        password.sendKeys("");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
        button.click();

        driver.quit();

    }

}
