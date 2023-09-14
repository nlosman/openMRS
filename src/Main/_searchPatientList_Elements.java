package Main;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _searchPatientList_Elements {

    public _searchPatientList_Elements() {

        PageFactory.initElements(BaseDriver.driver,this);
    }


    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"Inpatient Ward\"]")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    public WebElement patientRecordBtn;

    @FindBy(id = "patient-search")
    public WebElement search;

    @FindBy(className = "odd")
    public  WebElement patientClick;

    @FindBy(className = "dataTables_empty")
    public  WebElement error;


}
