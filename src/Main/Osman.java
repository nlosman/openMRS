package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Osman extends BaseDriver {
    @Test
    public void hastaKayit(){
        HastaKayitElements hke = new HastaKayitElements();
        driver.get("https://openmrs.org/");

        hke.demoBtn.click();
        hke.openMrsBtn.click();
        //MyFunc.Bekle(3);
        hke.openMrsDemoBtn.click();
        hke.usernameBox.sendKeys("admin");
        hke.passwordBox.sendKeys("Admin123");
        int randomSecim= (int)(Math.random()*hke.randomLctnBtn.size());
        hke.randomLctnBtn.get(randomSecim).click();
        hke.loginBtn.click();
        hke.registerPatientBtn.click();
        String firstName="Abuzer";
        hke.nameGivenBox.sendKeys(firstName);
        String lastName="Kadayif";
        hke.nameFamilyBox.sendKeys(lastName);
        hke.nextBtn.click();
        Select gender = new Select(hke.genderBox);
        gender.selectByIndex(0);
        hke.nextBtn.click();
        hke.dayBox.sendKeys("12");
        Select month = new Select(hke.monthBox);
        month.selectByIndex(4);
        hke.yearBox.sendKeys("1987");
        hke.nextBtn.click();
        hke.adressBox.sendKeys("Fatih Mah.");
        hke.cityBox.sendKeys("Istanbul");
        hke.stateBox.sendKeys("Marmara");
        hke.countryBox.sendKeys("Turkey");
        hke.postcodeBox.sendKeys("34567");
        hke.nextBtn.click();
        hke.phoneBox.sendKeys("+9054637721");
        hke.nextBtn.click();
        Select relation = new Select(hke.relationBox);
        relation.selectByIndex(2);
        hke.personNameBox.sendKeys("Apo Ibo");
        hke.nextBtn.click();
        hke.confirmBtn.click();
        Assert.assertEquals(hke.nameShow.getText(), firstName, "Hasta ismi gorunmuyor veya ayni degil");
        Assert.assertEquals(hke.lastNameShow.getText(), lastName, "Hasta soyismi gorunmuyor veya ayni degil");
        Assert.assertTrue(!hke.idText.getText().isEmpty(), "Id gorunmuyor");
















    }
}
