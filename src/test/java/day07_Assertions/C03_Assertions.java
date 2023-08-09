package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationpractice.com");

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
      //  driver.get("https://www.automationpractice.com");
        //sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
        WebElement mailkutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailkutusu.sendKeys("mehmetgmail.com" + Keys.ENTER);

        //invalid email adress" uyarisi ciktigini test edeliml
        WebElement uyariYazisielementi=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisielementi.isDisplayed());

    }


}
