package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main extends BaseDriver {
    //Sisteme Giriş (Login) Hatalarını Kontrol Etmek(US-1)
    @Test(dataProvider = "userData")
    public void loginHataKontrol(String username, String password) {
        //username,password
        driver.get("https://openmrs.org/");

        WebElement demo = driver.findElement(By.linkText("Demo"));
        demo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");

        WebElement openmrsdemo2 =
                driver.findElement(By.xpath("//*[@id='zak-content']/div/div/div/section[8]/div/div/div/div[1]/div/div/a"));
        openmrsdemo2.click();
        WebElement userName = driver.findElement(By.cssSelector("input[id='username']"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.cssSelector("input[name='password']"));
        passWord.sendKeys(password);
        WebElement inpatient = driver.findElement(By.id("Inpatient Ward"));
        inpatient.click();
        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();
        WebElement hataMesaji = driver.findElement(By.id("error-message"));
        Assert.assertEquals(hataMesaji.getText(), "Invalid username/password. Please try again.");

    }

    //Sisteme Giriş (Login) Yapmak(US-2)
    @Test
    public void loginTest() {
        PomElements pe = new PomElements();
        driver.get("https://openmrs.org/");

        pe.demoBtn.click();
        pe.openMrsBtn.click();
        MyFunc.Bekle(3);
        pe.openMrsDemoBtn.click();
        pe.usernameBox.sendKeys("admin");
        pe.passwordBox.sendKeys("Admin123");
        pe.location.click();
        pe.loginBtn.click();
    }

    //Sistemden Çıkış (Logout) Yapmak(US-3)
    @Test
    public void logoutTest() {

        driver.get("https://openmrs.org/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        js.executeScript("window.scrollTo(0, 500);");
        WebElement openMsr = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        openMsr.click();
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

        WebElement btn = driver.findElement(By.cssSelector("[type='submit']"));
        btn.click();

        //basarili oturum acma dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("home.page"));

        //secilen location sayfasi dogrulamasi
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='selected-location']"), "Inpatient Ward"));
        WebElement locationBtn = driver.findElement(By.xpath("//span[@id='selected-location']"));
        Assert.assertTrue(locationBtn.getText().equals("Inpatient Ward"), "Aranılan konum adi bulunamadı");

        WebElement logoutBtn = driver.findElement(By.xpath("//li[@class='nav-item logout']"));
        logoutBtn.click();

        //basarili logout sonucunda oturum acma sayfasi dogrulamasi
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    //Hasta Kayıt(US-4)
    @Test
    public void hastaKayit() {
        PomElements pe = new PomElements();
        driver.get("https://demo.openmrs.org/");

        pe.usernameBox.sendKeys("admin");
        pe.passwordBox.sendKeys("Admin123");
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
    }

    //Hasta Listesinde Arama(US-6)
    @Test
    public void hastaArama(){
        driver.get("https://demo.openmrs.org/");

        WebElement Username = driver.findElement(By.id("username"));
        Username.sendKeys("Admin");

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Admin123");

        WebElement InpatientWard = driver.findElement(By.xpath("//*[@id='Inpatient Ward']"));
        InpatientWard.click();

        WebElement LogIn = driver.findElement(By.id("loginButton"));
        LogIn.click();

        WebElement findPatientRecord =
                driver.findElement(By.xpath("//*[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        findPatientRecord.click();

        WebElement searchBox = driver.findElement(By.id("patient-search"));
        String aranacakHasta="Abuzer Kadayif";
        searchBox.sendKeys(aranacakHasta);
        WebElement hastaListe=driver.findElement(By.xpath("//tr[@class='odd']//td[text()='" +aranacakHasta + "']"));
        hastaListe.click();
    }
    //Hasta Silme(US-7)
    @Test
    public void hastaSilme(){
        driver.get("https://demo.openmrs.org/");

        WebElement Username = driver.findElement(By.id("username"));
        Username.sendKeys("Admin");

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Admin123");

        WebElement InpatientWard = driver.findElement(By.xpath("//*[@id='Inpatient Ward']"));
        InpatientWard.click();

        WebElement LogIn = driver.findElement(By.id("loginButton"));
        LogIn.click();

        WebElement findPatientRecord =
                driver.findElement(By.xpath("//*[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        findPatientRecord.click();

        WebElement searchBox = driver.findElement(By.id("patient-search"));
        searchBox.sendKeys("Ali Cabbar");

        WebElement patientName = driver.findElement(By.xpath("//*[@id='patient-search-results-table']/tbody"));
        patientName.click();

        WebElement deletePatient = driver.findElement(By.xpath("//*[@id='org.openmrs.module.coreapps.deletePatient']/div/div[2]"));
        deletePatient.click();

        WebElement reason = driver.findElement(By.id("delete-reason"));
        reason.sendKeys("YES");

        WebElement confirm = driver.findElement(By.xpath("//*[@id='delete-patient-creation-dialog']/div[2]/button[1]"));
        confirm.click();
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