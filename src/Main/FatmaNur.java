package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FatmaNur extends BaseDriver {


    @Test
    public void logoutTest() {

        driver.get("https://openmrs.org/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        js.executeScript("window.scrollTo(0, 500);");
        MyFunc.Bekle(2);

        WebElement openMsr = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        openMsr.click();
        MyFunc.Bekle(2);

        WebElement openMsrDemo = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[4]"));
        openMsrDemo.click();

        //oturum acma sayfasi dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("Admin123");

        WebElement location = driver.findElement(By.cssSelector("[id='Inpatient Ward']"));
        location.click();
        MyFunc.Bekle(2);

        WebElement btn = driver.findElement(By.cssSelector("[type='submit']"));
        btn.click();
        MyFunc.Bekle(2);

        //basarili oturum acma dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("home.page"));

        //secilen location sayfasi dogrulamasi
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='selected-location']"), "Inpatient Ward"));
        WebElement locationBtn = driver.findElement(By.xpath("//span[@id='selected-location']"));
        Assert.assertTrue( locationBtn.getText().equals("Inpatient Ward"),"Aranılan konum adi bulunamadı");

        WebElement logoutBtn = driver.findElement(By.xpath("//li[@class='nav-item logout']"));
        logoutBtn.click();

        //basarili logout sonucunda oturum acma sayfasi dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }


}
