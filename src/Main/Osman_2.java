package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Osman_2 extends BaseDriver {
    @Test
    public void hastaKayitBirlestirmr() {
        HastaKayitElements hke = new HastaKayitElements();
        driver.get("https://openmrs.org/");
        //Birinci hasta kaydi.
        hke.demoBtn.click();
        hke.openMrsBtn.click();
        MyFunc.Bekle(3);
        hke.openMrsDemoBtn.click();
        hke.usernameBox.sendKeys("admin");
        hke.passwordBox.sendKeys("Admin123");
        int randomSecim = (int) (Math.random() * hke.randomLctnBtn.size());
        hke.randomLctnBtn.get(randomSecim).click();
        hke.loginBtn.click();
        hke.registerPatientBtn.click();
        hke.nameGivenBox.sendKeys("Ahmet");
        hke.nameFamilyBox.sendKeys("Keser");
        hke.nextBtn.click();
        Select gender = new Select(hke.genderBox);
        gender.selectByIndex(0);
        hke.nextBtn.click();
        hke.dayBox.sendKeys("11");
        Select month = new Select(hke.monthBox);
        month.selectByIndex(4);
        hke.yearBox.sendKeys("1978");
        hke.nextBtn.click();
        hke.adressBox.sendKeys("Portakal Sokak");
        hke.cityBox.sendKeys("Ankara");
        hke.stateBox.sendKeys("Icanadolu");
        hke.countryBox.sendKeys("Turkey");
        hke.postcodeBox.sendKeys("06789");
        hke.nextBtn.click();
        hke.phoneBox.sendKeys("+906789876");
        hke.nextBtn.click();
        Select relation = new Select(hke.relationBox);
        relation.selectByIndex(4);
        hke.personNameBox.sendKeys("Cem Yilmaz");
        hke.nextBtn.click();
        hke.confirmBtn.click();
        String id_1=hke.idText.getText();

        //Ikinci hasta kaydi.
        driver.get("https://openmrs.org/");
        hke.demoBtn.click();
        hke.openMrsBtn.click();
        MyFunc.Bekle(3);
        hke.openMrsDemoBtn.click();
        hke.registerPatientBtn.click();
        hke.nameGivenBox.sendKeys("Mehmet");
        hke.nameFamilyBox.sendKeys("Beser");
        hke.nextBtn.click();
        gender.selectByIndex(0);
        hke.nextBtn.click();
        hke.dayBox.sendKeys("22");
        month.selectByIndex(7);
        hke.yearBox.sendKeys("1982");
        hke.nextBtn.click();
        hke.adressBox.sendKeys("kizilelma cad");
        hke.cityBox.sendKeys("Trabzon");
        hke.stateBox.sendKeys("Karadeniz");
        hke.countryBox.sendKeys("Turkey");
        hke.postcodeBox.sendKeys("61897");
        hke.nextBtn.click();
        hke.phoneBox.sendKeys("+905424563456");
        hke.nextBtn.click();
        relation.selectByIndex(6);
        hke.personNameBox.sendKeys("Yilmaz Morgul");
        hke.nextBtn.click();
        hke.confirmBtn.click();
        String id_2=hke.idText.getText();

        //Kayit birlestirme.
        driver.get("https://openmrs.org/");
        hke.demoBtn.click();
        hke.openMrsBtn.click();
        MyFunc.Bekle(3);
        hke.openMrsDemoBtn.click();
        hke.dataManagementBtn.click();
        hke.mergePatientBtn.click();
        hke.patientID_1Box.sendKeys(id_1);
        hke.patientID_2Box.sendKeys(id_2 + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(hke.continueBtn)).click();
        hke.hastaSecimi.click();
        Assert.assertEquals(hke.cannotMergetext.getText(), "Merging cannot be undone!\n" +
                "Please check records before continuing.");
        hke.yesConBtn.click();
        Assert.assertEquals(hke.idText_1.getText(), id_2);
        Assert.assertEquals(hke.idText_2.getText(), id_1);




    }
}
