package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {
        driver.close();

    }

    @Test

    public void test01() {
        /*eger test metodumuzda hicbir test yoksa,test calistikdan sonra hicbir problemle karsilasilmadigini raporlamak
         icin test Passed yazisi cikar

         *eger testleri if ile yaparsak test FAILED olsa bile kodlar problemsiz calistigi icin kod calismasi bittiginde
         ekranin sol alt kisminda test PASSED olacaktir.

         */
        driver.get("https://www.amazon.com");

       /*
        //url'in https://www.facebook.com oldugunu test edin

        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("url testi PASSED");
        }else{
            System.out.println("url testi Failed");
        }

        */
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("URL beklenenden farkli",expectedUrl,actualUrl);
        /*
        Assert ile yaptigimiz testlerde assertion failed olursa Java kodlarin calismasini durdurur ve Assert class'i
        bizi hata konusunda bilgilendirir
         */
        /*
        bize terminalde verilen cevap
        org.junit.ComparisonFailure:
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com/
<Click to see difference>
boylece hatanin ne oldugunu arastirmamiza gerek kalmadan JUnit bize raporlamis olacak

         */

    }
}
