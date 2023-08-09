package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeClass_AfterClass {
    /*
    beforeclass ve afterclass notasyonlari sadece statik metodlar icin calisir
     */
   static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();


    }

    @Test
    public  void test01(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test03() {
        driver.get("https://www.facebook.com");
    }

}