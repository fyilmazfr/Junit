package day09_HandleWindows_TestBase;

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
import java.util.Set;

public class C03_WindowHandles {
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
        //   driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");
        //sayfadaki textin "opening a new window "oldugunu dogrulayin
        WebElement sAYFADAKIyAZIelementi = driver.findElement(By.xpath("//h3"));
        String actualYazi = sAYFADAKIyAZIelementi.getText();
        String expectedYazi = "Opening a new window";
        Assert.assertEquals(expectedYazi, actualYazi);
        //sayfa basliginin (title) "The Internet" oldugunu dogrulayin
        String expectedTITLE = "The Internet";
        String actualTITLE = driver.getTitle();
        Assert.assertEquals(expectedTITLE, actualTITLE);
        /*
        eger kontrolsuz acilan bir tab veya window varsa ozaman sayfalari window handle degerlerini elde etmem
        gerekir
        oncelikle ikinci sayfa acilmadan once ilk sayfanin windowhandle degerini bir stringe atayalim
         */
        String ilkSayfaWIndowHandleDegeri=driver.getWindowHandle();


        //Click Here butonuna basin
        driver.findElement(By.linkText("Click Here")).click();
        /*
        switchTO.newWindow() demeden link tiklayarak yeni tab veya window olustugunda biz driver'a yeni sayfaya gec
        demedikce ,driver eski sayfada kalir ve yeni sayfaile ilgili hicbirislem yapamaz
        yeni sayfada driver'i calistirmak isterseniz once driver'i yeni sayfaya yollamalisiniz
         */
        /*
        yeni sayfaya gecebilmek icin oncelikle ikinci sayfa window handle degerini bulmamiz gerekir
        bunun icin driver.getWindowHandles methodunu kullanarak acik olan tum sayfalarin window handle degerlerini alip bir
        set'e assign ederiz
        ilk sayfanin windowhandle degerini zaten biliyoruz
        set'teki windowhandle degerlerini kontrol edip ilk sayfanin handle degerine esit olmayan ikinci sayfanin
        windowhandle degeridir deriz

         */

       Set<String> windowHandleseti =driver.getWindowHandles();

        System.out.println(windowHandleseti);
        String ikincisayfawindowHandleDegeri="";

        for (String each:windowHandleseti) {
            if (!each.equals(ilkSayfaWIndowHandleDegeri)){
                ikincisayfawindowHandleDegeri=each;
            }
        }
        //artik ikinci sayfanin windowhandle degrini biliyoruz rahatlikla sayfalar arasi gecis yapabiliriz
        driver.switchTo().window(ikincisayfawindowHandleDegeri);

        //acilan yeni pencerenin sayfa basliginin "New Window" oldugunu dogrulayin
        String expectedikinciTITLe = "New Window";
        String actualikinciTitle = driver.getTitle();
        Assert.assertEquals(expectedikinciTITLe, actualikinciTitle);

        //sayfadaki textin "New Window " oldugunu dogrulayin.
        WebElement ikinciSayfayaziElementi= driver.findElement(By.xpath("//h3"));
        String expectedikinciYazi="New Window";
        String actualikinciYazi=ikinciSayfayaziElementi.getText();
        Assert.assertEquals(expectedikinciYazi,actualikinciYazi);

        //bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugununu dogrulayin
        driver.switchTo().window(ilkSayfaWIndowHandleDegeri);
         expectedTITLE = "The Internet";
         actualTITLE = driver.getTitle();
         Assert.assertEquals (expectedTITLE,actualTITLE);



    }
}
