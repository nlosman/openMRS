package Utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri(){
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().window().maximize(); //
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @AfterClass
    public void bitisIslemleri(){
        MyFunc.Bekle(5);
        driver.quit();
    }

}
