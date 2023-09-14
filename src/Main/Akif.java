package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Akif extends BaseDriver {

    @Test
    public void searchPatientList(){
        driver.get("https://demo.openmrs.org/");

        _searchPatientList_Elements elm =  new _searchPatientList_Elements();

        elm.username.sendKeys("Admin");
        elm.password.sendKeys("Admin123");
        elm.inpatientWard.click();
        elm.loginButton.click();
        elm.patientRecordBtn.click();
        elm.search.sendKeys("Robert Hall");
        MyFunc.Bekle(1);
        elm.patientClick.click();
        MyFunc.Bekle(1);
        driver.navigate().back();
        elm.search.sendKeys("adasdasd");
        MyFunc.Bekle(1);
        Assert.assertTrue(elm.error.getText().contains("No matching records found"));




    }

}
