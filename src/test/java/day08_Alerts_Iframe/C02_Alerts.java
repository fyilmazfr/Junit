package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
   static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();
        Assert.assertEquals(expectedResult,actualResultYazisi);
    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenREsult="successfuly";//istenmeyen kelime
        WebElement sonucYzisi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi=sonucYzisi.getText();
        Assert.assertFalse(actualYazi.contains(istenmeyenREsult));
    }
    @Test
    public void sendKeysALERT(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("YILMAZ");
        driver.switchTo().alert().accept();
        String expectedREsult="YILMAZ";//girilen isim
        WebElement sonucYzisi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi=sonucYzisi.getText();

        Assert.assertTrue(actualYazi.contains(expectedREsult));


    }




}
