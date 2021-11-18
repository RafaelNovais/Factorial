package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FactoriallPage {

    public WebDriver driver;


    public FactoriallPage(WebDriver driver){
        this.driver = driver;

    }

    public String getTitle(){

        return driver.getTitle();

    }

    public void setNumber(int number){

        WebElement Element = (WebElement) driver.findElement(By.id("number"));
        Element.sendKeys(Integer.toString(number));
        driver.findElement(By.id("getFactorial")).click();


    }

}
