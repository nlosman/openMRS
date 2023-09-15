package Main;

import Utility.BaseDriver;
import Utility.MyFunc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main extends BaseDriver {

    //Sisteme Giriş (Login) Hatalarını Kontrol Etmek(US-1)
    @Test(dataProvider = "userData", groups = {"Smoke", "Login"}, priority = 1)
    public void loginHataKontrol(String username, String password) {
        PomElements pe = new PomElements();
        driver.get("https://openmrs.org/");

        pe.demoBtn.click();
        pe.openMrsBtn.click();
        MyFunc.Bekle(2);
        pe.openMrsDemoBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(pe.loginBtn));
        pe.username.sendKeys(username);
        pe.password.sendKeys(password);
        pe.location.click();
        pe.loginBtn.click();
        Assert.assertEquals(pe.hataMesaji.getText(), "Invalid username/password. Please try again.");


    }

    //Sisteme Giriş (Login) Yapmak(US-2)
    @Test(groups = {"Smoke", "Login"}, priority = 2)
    public void loginTest() {
        PomElements pe = new PomElements();
        driver.get("https://openmrs.org/");

        pe.demoBtn.click();
        pe.exploreBtn.click();
        MyFunc.Bekle(3);
        pe.enterBtn.click();
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();


    }

    //Sistemden Çıkış (Logout) Yapmak(US-3)
    @Test(groups = {"Smoke", "Logout"}, priority = 3)
    public void logoutTest() {
        PomElements pe = new PomElements();
        driver.get("https://openmrs.org/");
        pe.demoBtn.click();
        pe.exploreBtn.click();
        MyFunc.Bekle(3);
        pe.enterBtn.click();

        //oturum acma sayfasi dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.inpatientWard.click();
        pe.loginBtn.click();

        //basarili oturum acma dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("home.page"));

        //secilen location sayfasi dogrulamasi
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='selected-location']"), "Inpatient Ward"));

        Assert.assertTrue(pe.locationBtn.getText().equals("Inpatient Ward"), "Aranılan konum adi bulunamadı");
        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

        //basarili logout sonucunda oturum acma sayfasi dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }

    //Hasta Kayıt(US-4)
    @Test(groups = "Regression", priority = 4)
    public void hastaKayit() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");

        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        int randomSecim = (int) (Math.random() * pe.randomLctnBtn.size());
        pe.randomLctnBtn.get(randomSecim).click();
        pe.loginBtn.click();
        pe.registerPatientBtn.click();
        String firstName = "Abuzer";
        pe.nameGivenBox.sendKeys(firstName);
        String lastName = "Kadayif";
        pe.nameFamilyBox.sendKeys(lastName);
        pe.nextBtn.click();
        Select gender = new Select(pe.genderBox);
        gender.selectByIndex(0);
        pe.nextBtn.click();
        pe.dayBox.sendKeys("12");
        Select month = new Select(pe.monthBox);
        month.selectByIndex(4);
        pe.yearBox.sendKeys("1987");
        pe.nextBtn.click();
        pe.adressBox.sendKeys("Fatih Mah.");
        pe.cityBox.sendKeys("Istanbul");
        pe.stateBox.sendKeys("Marmara");
        pe.countryBox.sendKeys("Turkey");
        pe.postcodeBox.sendKeys("34567");
        pe.nextBtn.click();
        pe.phoneBox.sendKeys("+9054637721");
        pe.nextBtn.click();
        Select relation = new Select(pe.relationBox);
        relation.selectByIndex(2);
        pe.personNameBox.sendKeys("Apo Ibo");
        pe.nextBtn.click();
        pe.confirmBtn.click();
        Assert.assertEquals(pe.nameShow.getText(), firstName, "Hasta ismi gorunmuyor veya ayni degil");
        Assert.assertEquals(pe.lastNameShow.getText(), lastName, "Hasta soyismi gorunmuyor veya ayni degil");
        Assert.assertTrue(!pe.idText.getText().isEmpty(), "Id gorunmuyor");
        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

    }
    //Hesabım (My Account)(US-5)
    @Test(groups = "Smoke", priority = 5)
    public void accountTest() {
        PomElements pe = new PomElements();

        driver.get("https://demo.openmrs.org/");

        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.inpatientWard.click();
        pe.loginBtn.click();
        Actions actions= new Actions(driver);
        actions.moveToElement(pe.adminHover).build().perform();
        MyFunc.Bekle(2);
        pe.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(pe.changePassword));
        pe.changePassword.click();
        driver.navigate().back();
        wait.until(ExpectedConditions.elementToBeClickable(pe.myLanguages));
        pe.myLanguages.click();

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

    }

    //Hasta Listesinde Arama(US-6)
    @Test(groups = "PatientManagement", priority = 6)
    public void hastaArama() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.inpatientWard.click();
        pe.loginBtn.click();
        pe.patientRecordBtn.click();
        pe.search.sendKeys("Robert Hall");
        pe.patientClick.click();
        driver.navigate().back();
        pe.search.sendKeys("adasdasd");
        wait.until(ExpectedConditions.visibilityOf(pe.error));
        MyFunc.Bekle(3);
        System.out.println(pe.error.getText());
        Assert.assertTrue(pe.error.getText().contains("No matching records found"));

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

    }
    //Hasta Silme(US-7)
    @Test(groups = "Smoke, PatientManagement", priority = 7)
    public void hastaSilme() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.inpatientWard.click();
        pe.loginBtn.click();
        pe.findPatientRecord.click();
        pe.search.sendKeys("Ali Cabbar");
        pe.patientName.click();
        pe.deletePatient.click();
        pe.reason.sendKeys("YES");
        pe.confirm.click();

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

    }

    //Hasta Listeleme(US-8)
    @Test(groups = "Regression, PatientManagement", priority = 8)
    public void hastaListeleme() {
        PomElements pe = new PomElements();

        driver.get("https://openmrs.org");

        //Login
        pe.demoBtn.click();
        pe.exploreBtn.click();
        MyFunc.Bekle(2);
        pe.enterBtn.click();
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();

        // Hastalari Listele
        pe.openList.click();

        // Sayfa basi listelenen hasta sayisi
        int pagePerItem = pe.list.size();

        // Sonuc satirindan harfleri kaldir
        String resultToNumber = pe.result.getText().replaceAll("[^0-9]", "");

        // Pagination son item indexsini al
        int lastItemIndex = pe.pagination.size() - 1;

        // Paginatin en son sayfaya git
        pe.pagination.get(lastItemIndex).click();

        // En son sayfadaki hasta sayisini al
        int lastPageItems = pe.list.size();

        // Toplam hasta sayisini Stringden numbere cevir ve icinden toplam hasta sayisini al
        int totalItems = Integer.parseInt(resultToNumber.substring(3));

        // Toplam hasta sayisini check et
        Assert.assertTrue((pe.pagination.size() - 1) * pagePerItem + lastPageItems == totalItems, "Totaal item esit degil!!!");

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();
    }

    //Hasta Kayit Birlestieme(US-9)
    @Test(groups = "Regression, PatientManagement", priority = 9)
    public void hastaKayitBirlestirme() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");
        //Birinci hasta kaydi.
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();
        pe.registerPatientBtn.click();
        pe.nameGivenBox.sendKeys("Ahmet");
        pe.nameFamilyBox.sendKeys("Keser");
        pe.nextBtn.click();
        Select gender = new Select(pe.genderBox);
        gender.selectByIndex(0);
        pe.nextBtn.click();
        pe.dayBox.sendKeys("11");
        Select month = new Select(pe.monthBox);
        month.selectByIndex(4);
        pe.yearBox.sendKeys("1978");
        pe.nextBtn.click();
        pe.adressBox.sendKeys("Portakal Sokak");
        pe.cityBox.sendKeys("Ankara");
        pe.stateBox.sendKeys("Icanadolu");
        pe.countryBox.sendKeys("Turkey");
        pe.postcodeBox.sendKeys("06789");
        pe.nextBtn.click();
        pe.phoneBox.sendKeys("+906789876");
        pe.nextBtn.click();
        Select relation = new Select(pe.relationBox);
        relation.selectByIndex(4);
        pe.personNameBox.sendKeys("Cem Yilmaz");
        pe.nextBtn.click();
        pe.confirmBtn.click();
        String id_1 = pe.idText.getText();

        //Ikinci hasta kaydi.
        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();
        pe.registerPatientBtn.click();
        pe.nameGivenBox.sendKeys("Mehmet");
        pe.nameFamilyBox.sendKeys("Beser");
        pe.nextBtn.click();
        gender.selectByIndex(0);
        pe.nextBtn.click();
        pe.dayBox.sendKeys("22");
        month.selectByIndex(7);
        pe.yearBox.sendKeys("1982");
        pe.nextBtn.click();
        pe.adressBox.sendKeys("kizilelma cad");
        pe.cityBox.sendKeys("Trabzon");
        pe.stateBox.sendKeys("Karadeniz");
        pe.countryBox.sendKeys("Turkey");
        pe.postcodeBox.sendKeys("61897");
        pe.nextBtn.click();
        pe.phoneBox.sendKeys("+905424563456");
        pe.nextBtn.click();
        relation.selectByIndex(6);
        pe.personNameBox.sendKeys("Yilmaz Morgul");
        pe.nextBtn.click();
        pe.confirmBtn.click();
        String id_2 = pe.idText.getText();

        //Kayit birlestirme.
        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();
        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();
        pe.dataManagementBtn.click();
        pe.mergePatientBtn.click();
        pe.patientID_1Box.sendKeys(id_1);
        pe.patientID_2Box.sendKeys(id_2 + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(pe.continueBtn)).click();
        pe.hastaSecimi.click();
        Assert.assertEquals(pe.cannotMergetext.getText(), "Merging cannot be undone!\n" +
                "Please check records before continuing.");
        pe.yesConBtn.click();
        Assert.assertEquals(pe.idText_1.getText(), id_2);
        Assert.assertEquals(pe.idText_2.getText(), id_1);

        wait.until(ExpectedConditions.elementToBeClickable(pe.logoutBtn));
        MyFunc.Bekle(3);
        pe.logoutBtn.click();

    }
    //Hasta randevusu alırken yanlış saat dilimi(US-10)
    @Test(groups = "Regression, Appointment",
            dependsOnMethods = {"loginTest"}, priority = 10)

    public void yanlisSaatDilimi() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");

        pe.username.sendKeys("admin");
        pe.password.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();
        pe.appoinmentScheduling.click();
        pe.manageAppointments.click();
        pe.search.sendKeys("Abuzer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("odd")));
        pe.aramaSonuc.click();
        Assert.assertEquals(pe.dogrulama.getText(), "Your computer is not set to the right time zone. " +
                "Please change to Coordinated Universal Time and then close and restart your browser " +
                "to assure proper scheduling functionality.");

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