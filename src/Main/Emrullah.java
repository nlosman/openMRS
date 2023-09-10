package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.Test;

public class Emrullah extends BaseDriver {

    @Test
    void ListOfPatient() {
        ListOfPatientsElenemts elm = new ListOfPatientsElenemts();
        driver.get("https://openmrs.org");

        //Login
        elm.demoBtn.click();
        elm.exploreBtn.click();
        elm.enterBtn.click();
        elm.username.sendKeys("admin");
        elm.password.sendKeys("Admin123");
        elm.location.click();
        elm.loginButton.click();

        //Hastalari Listele

        MyFunc.Bekle(5);

    }
}
