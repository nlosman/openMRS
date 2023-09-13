package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Suleyman extends BaseDriver{
    @Test
    public void yanlisSaatDilimi (){
        driver.get("https://demo.openmrs.org/");

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");
        WebElement inpatientWard = driver.findElement(By.id("Inpatient Ward"));
        inpatientWard.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        WebElement appoinmentScheduling = driver.findElement(By.xpath("//a[contains(@id,'appointmentschedulingui')]"));
        appoinmentScheduling.click();
        WebElement manageAppointments = driver.findElement(By.xpath("//a[contains(@id,'manageAppointments')]"));
        manageAppointments.click();
        WebElement patientSearch = driver.findElement(By.id("patient-search"));
        patientSearch.sendKeys("Abuzer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("odd")));
        WebElement aramaSonuc = driver.findElement(By.xpath("(//tr[@class='odd'])//td"));
        aramaSonuc.click();
        WebElement dogrulama = driver.findElement(By.xpath("//*[@id='time-zone-warning']/div/div/p"));
        Assert.assertEquals(dogrulama.getText(), "Your computer is not set to the right time zone. " +
                "Please change to Coordinated Universal Time and then close and restart your browser " +
                "to assure proper scheduling functionality.");
    }

}