package day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    static public void tearDown() {
        //driver.close();
    }

    @Test
    public void Test01() {
        //amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        String ilksayfaHANDLEdegeri = driver.getWindowHandle();

        //nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("NUTELLA" + Keys.ENTER);


        /*
        57C6D2ACEC42B096A27076DDC93E4F1F
        bu kod acilan sayafanin unique hash kodudur,selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadansuanda bulundugumuz sayfada gecmek istiyorsak
        driver.switchTo().window("57C6D2ACEC42B096A27076DDC93E4F1F");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        //3- ILK urunun resmini TIKLAYARAK farkli bir tab olarak acin
        WebElement ilkurunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);

        /*
        bu komutu kullandigimizda driver otomatik olarak olusturulan new TAb'a gecer
        yeni tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir
         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("NUTELLA" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();


        //4- yeni tab'da acilan urunun title'ini yazdirin yazdirin
        WebElement urunTitle= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitle.getText());

        //ilk sayfaya gecip url'i yazdirialim
        driver.switchTo().window(ilksayfaHANDLEdegeri);
        System.out.println(driver.getCurrentUrl());


    }
}
