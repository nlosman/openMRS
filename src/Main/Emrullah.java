package Main;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.Assert;
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

        // Hastalari Listele
        elm.openList.click();

        // Sayfa basi listelenen hasta sayisi
        int pagePerItem =  elm.list.size();

        // Sonuc satirindan harfleri kaldir
        String resultToNumber = elm.result.getText().replaceAll("[^0-9]", "");

        // Pagination son item indexsini al
        int lastItemIndex = elm.pagination.size() - 1;

        // Paginatin en son sayfaya git
        elm.pagination.get(lastItemIndex).click();

        // En son sayfadaki hasta sayisini al
        int lastPageItems =  elm.list.size();

        // Toplam hasta sayisini Stringden numbere cevir ve icinden toplam hasta sayisini al
        int totalItems = Integer.parseInt(resultToNumber.substring(3));

        // Toplam hasta sayisini check et
        Assert.assertTrue((elm.pagination.size() - 1) * pagePerItem + lastPageItems == totalItems, "Totaal item esit degil!!!");
    }
}
