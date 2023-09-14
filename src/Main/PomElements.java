package Main;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PomElements {
    public PomElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath="//*[@class='zak-button']")
    public WebElement demoBtn;

    @FindBy(linkText = "Explore OpenMRS 2")
    public WebElement exploreBtn;
    @FindBy(linkText = "Enter the OpenMRS 2 Demo")
    public WebElement enterBtn;
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(id = "Outpatient Clinic")
    public WebElement location;
    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    public WebElement openList;

    @FindBy(xpath="//*[@id='patient-search-results-table'] / tbody / tr")
    public List<WebElement> list;

    @FindBy(id = "patient-search-results-table_info")
    public WebElement result;

    @FindBy(xpath="//*[@id='patient-search-results-table_paginate'] / span / a")
    public List<WebElement> pagination;

    @FindBy(xpath = "(//*[@class='elementor-button-text'])[2]")
    public WebElement openMrsBtn;
    @FindBy(xpath = "(//a[@class='elementor-button elementor-button-link elementor-size-sm elementor-animation-grow'])[4]")
    public WebElement openMrsDemoBtn;
    @FindBy(id = "username")
    public WebElement usernameBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "(//ul[@id='sessionLocation'])//li")
    public List<WebElement> randomLctnBtn;
    @FindBy(id = "loginButton")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[contains(@id,'register')]")
    public WebElement registerPatientBtn;
    @FindBy(name = "givenName")
    public WebElement nameGivenBox;
    @FindBy(name = "familyName")
    public WebElement nameFamilyBox;
    @FindBy(id = "gender-field")
    public WebElement genderBox;
    @FindBy(id = "next-button")
    public WebElement nextBtn;
    @FindBy(id = "birthdateDay-field")
    public WebElement dayBox;
    @FindBy(id="birthdateMonth-field")
    public WebElement monthBox;
    @FindBy(id="birthdateYear-field")
    public WebElement yearBox;
    @FindBy(id = "address1")
    public WebElement adressBox;
    @FindBy(id = "cityVillage")
    public WebElement cityBox;
    @FindBy(id="stateProvince")
    public WebElement stateBox;
    @FindBy(id="country")
    public WebElement countryBox;
    @FindBy(id="postalCode")
    public WebElement postcodeBox;
    @FindBy(name="phoneNumber")
    public WebElement phoneBox;
    @FindBy(id="relationship_type")
    public WebElement relationBox;
    @FindBy(xpath = "(//input[@type='text'])[15]")
    public WebElement personNameBox;
    @FindBy(id="submit")
    public WebElement confirmBtn;
    @FindBy(className = "PersonName-givenName")
    public WebElement nameShow;
    @FindBy(className = "PersonName-familyName")
    public WebElement lastNameShow;
    @FindBy(css = "[class='float-sm-right'] >span")
    public WebElement idText;
    @FindBy(linkText = " Logout ")
    public WebElement logoutBtn;

    @FindBy(xpath = "//a[contains(@id,'datamanagement')]")
    public WebElement dataManagementBtn;
    @FindBy(className = "icon-group")
    public WebElement mergePatientBtn;
    @FindBy(id="patient1-text")
    public WebElement patientID_1Box;
    @FindBy(id="patient2-text")
    public WebElement patientID_2Box;
    @FindBy(id="confirm-button")
    public WebElement continueBtn;
    @FindBy(css = "[class='row name']")
    public WebElement hastaSecimi;
    @FindBy(xpath = "//div[@class='messages-container']//h1")
    public WebElement cannotMergetext;
    @FindBy(id="confirm-button")
    public WebElement yesConBtn;
    @FindBy(xpath = "(//div[@class='float-sm-right'])//span[1]")
    public WebElement idText_1;
    @FindBy(xpath = "(//div[@class='float-sm-right'])//span[2]")
    public WebElement idText_2;
}
