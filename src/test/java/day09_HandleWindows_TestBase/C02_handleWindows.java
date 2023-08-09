package day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
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
        driver.quit();
    }

    @Test
    public void Test01() {
        //1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();//bunu surekli kullanacagimiz icin basta alalim

        //2- url'in amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(istenenKelime));

        //3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bestbuy.com");
        String ikinciSayfaWindowHandleDegeri=driver.getWindowHandle();//yine handle degeri aldik kullanacagiz gecisler icin

        //4- title'in bestbuy icerdigini test edelim
        String actualTitle= driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //5-ilk sayfaya donup sayfa'da java aratalim
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);



        //6- arama sonuclarinin java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String sonucYazisiSTR=sonucYaziElementi.getText();
        System.out.println(sonucYazisiSTR);
        String aradigimizKelime="Java";
        Assert.assertTrue(sonucYazisiSTR.contains(aradigimizKelime));

        //7- yeniden bestbuy 'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        //8- logonun gorundugunu test edelim
        WebElement logoElementi= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/img"));
        Assert.assertTrue(logoElementi.isDisplayed());









    }
    }


