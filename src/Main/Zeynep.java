package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.awt.SystemColor.menu;

public class Zeynep extends BaseDriver {

    @Test
    public void accountTest() {


        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement Username= driver.findElement(By.id("username"));
        Username.sendKeys("admin");
        MyFunc.Bekle(2);

        WebElement Password= driver.findElement(By.id("password"));
        Password.sendKeys("Admin123");
        MyFunc.Bekle(2);

        WebElement InpatientWard= driver.findElement(By.xpath("//*[@id=\"Inpatient Ward\"]"));
        InpatientWard.click();
        MyFunc.Bekle(2);

        WebElement LogIn= driver.findElement(By.id("loginButton"));
        LogIn.click();
        MyFunc.Bekle(2);

        WebElement AdminHover= driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]"));
        MyFunc.Bekle(2);

        Actions actions= new Actions(driver);    //MyFunc.Bekle(2);
        actions.moveToElement(AdminHover).build().perform();

        WebElement myAccount= driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/myAccount.page']"));
        myAccount.click();

        String actualText = "My Account";
        Assert.assertTrue(actualText.contains("My Account"), "expected text bulunamadi.");

        driver.close();


    
    }


}
