package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Dilek extends BaseDriver {
    @Test(dataProvider = "userData")
    public void Test1(String username, String password) {
        //username,password
        driver.get("https://openmrs.org/");

        WebElement demo = driver.findElement(By.linkText("Demo"));
        demo.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");

        WebElement openmrsdemo2 =
                driver.findElement(By.xpath("//*[@id='zak-content']/div/div/div/section[8]/div/div/div/div[1]/div/div/a"));
        openmrsdemo2.click();
        // MyFunc.Bekle(3);


        WebElement userName = driver.findElement(By.cssSelector("input[id='username']"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.cssSelector("input[name='password']"));
        passWord.sendKeys(password);
        WebElement inpatient = driver.findElement(By.id("Inpatient Ward"));
        inpatient.click();


        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

    }

    @DataProvider
    public Object[][] userData() {
        Object[][] data = {
                {"", ""},
                {"", "124"},
                {"adimi", "012"},
                {"ademn", ""},

        };
        return data;

    }


}
