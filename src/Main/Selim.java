package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Selim extends BaseDriver {

    @Test

    public void HastaSilme(){

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement Username= driver.findElement(By.id("username"));
        Username.sendKeys("Admin");
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

        WebElement FindPatientRecord=
                driver.findElement(By.xpath("//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]"));

        FindPatientRecord.click();
        MyFunc.Bekle(2);

        WebElement searchBox= driver.findElement(By.id("patient-search"));
        searchBox.sendKeys("Ali Cabbar");
        MyFunc.Bekle(3);


        WebElement PatientName= driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody"));
        PatientName.click();
        MyFunc.Bekle(2);

        WebElement DeletePatient= driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.deletePatient\"]/div/div[2]"));
        DeletePatient.click();
        MyFunc.Bekle(2);

        WebElement Reason=driver.findElement(By.id("delete-reason"));
        Reason.sendKeys("YES");
        MyFunc.Bekle(2);

        WebElement CONFIRM=driver.findElement(By.xpath("//*[@id=\"delete-patient-creation-dialog\"]/div[2]/button[1]"));
        CONFIRM.click();

        driver.close();




    }

}
