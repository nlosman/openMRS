package Main;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListOfPatientsElenemts {
    public ListOfPatientsElenemts() {
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
}
