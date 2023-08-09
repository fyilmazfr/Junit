package day07_Assertions;

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

public class C01_Assertions {
    /*
    AMAZON ANA SAYFAYA GIDIN
    3 farkli test methodu olusturarak asagidaki gorevleri yapin
     1- url'in amazon icerdigini test edin
     2-title'in facebook icermedigini test edin
     3-sol ust kosede amazon logosunun gorundugunu test edin

     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com"); //simdilik bunu buraya tasidik test1'den

    }
    @AfterClass
    public static void tearDown(){
        driver.close();

    }
    @Test
    public void test01(){


        //1- url'in amazon icerdigini test edin
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }
    //2-title'in facebook icermedigini test edin
    @Test
    public void test02(){
        String istenmeyenkelime="facebook";
        String actualtitle= driver.getTitle();
        Assert.assertFalse(actualtitle.contains(istenmeyenkelime));
    }
    //3-sol ust kosede amazon logosunun gorundugunu test edin
    @Test
    public void test03(){//test 1'de zaten amazona gitmistik suan icin tekrar amazona gitmemize gerek yok
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());//gorunuyormu diye sorduk



    }

}
