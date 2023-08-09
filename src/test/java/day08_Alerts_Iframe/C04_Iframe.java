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

public class C04_Iframe {
    static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
   static public  void tearDown(){
        //driver.quit();
    }

    @Test
    public  void test01() throws InterruptedException {
        driver.get(" https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi= driver.findElement(By.xpath("//h3"));
        //An iFrame containing ... textinin erisilebilir oldugunu test edin
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        //text box'a merhaba dunya yazin
        //text box'i dogru locate etmemize ragmen driver bulamadi,bunun uzerine html kodlari inceleyince textbox'in
        // ASLINDA bir iframe icerisinde oldugunu gorduk bu durumda once iframe'i locate edip switchTO() ile
        //o iframe'e gecmeliyiz
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);

        WebElement testKutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
        testKutusu.clear();
        testKutusu.sendKeys("MERHABA DUNYA");

        driver.switchTo().defaultContent();//iframe'den cikmamiz gerekiyor ,ANASAYFA ya cikar

        WebElement linkYaziElementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(5000);

    }}
