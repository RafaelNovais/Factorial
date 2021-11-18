import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.FactoriallPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SiteTestFactorial {

    private WebDriver driver;
    private final String baseUrl = "http://qainterview.pythonanywhere.com/";
    private final String driverPath = "C:/chromedriver.exe"; //Please check your Chrome Web Driver, Version 96.0.4664.45
    private FactoriallPage receivedPage;


    @BeforeAll
    public void config(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

  //  @AfterAll
  //  public void tearDown () {
  //      driver.close();
  //  }

    @Test
    @DisplayName("When get  site then return if the title is correct")
    public void checkTitle(){

        driver.get(baseUrl);
        String TitleExpected = "Factoriall";
        String TitleReceived;

        receivedPage = new FactoriallPage(driver);
        TitleReceived = receivedPage.getTitle();

        assertThat(TitleReceived,containsString(TitleExpected));

    }

    @Test
    @DisplayName("When set number 5 in the site then return: The factorial of 5 is: 120")
    public void checkFactorial5(){

        driver.get(baseUrl);
        String AnswerExpected = "The factorial of 5 is: 120";
        int Number = 5;

        receivedPage = new FactoriallPage(driver);
        receivedPage.setNumber(Number);
        String AnswerReceived = driver.findElement(By.id("resultDiv")).getText();


        assertThat(AnswerReceived,is(equalTo(AnswerExpected)));

    }


}
