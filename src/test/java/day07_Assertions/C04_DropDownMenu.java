package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip  dropdown'dan books secenegini secip java aratalim, ve arama sonuclarinin java icerdigini test edelim
     */

    WebDriver driver;
     @Before
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     }
     @After
    public void tearDown(){
         driver.quit();
     }
     @Test
    public void test01() throws InterruptedException {
         driver.get("https://www.amazon.fr");
         //dropdown'dan bir option secmek icin 3 adim vardir
         //1- dropdown'i locate edelim
         WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

         //2- bir select objesi olusturup parametre olarak bir onceki adimda locate ettiginiz ddm'yi girelim
         Select select=new Select(dropDownMenu);

         //3- ddm 'de var olan options olan istedigimiz bir tanesini secelim


         //select.selectByIndex(28);//index'e gore secim yapar
         //select.selectByValue("search-alias=stripbooks");//valu ile secer
         select.selectByVisibleText("Livres");//gorunur isimle seciyor

         //arama kutusuna java yazdiralim
         WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));//"twotabsearchtextbox" arama kutusu kisa yolu
         aramaKutusu.sendKeys("Java"+ Keys.ENTER);

         WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
         String sonucYazisiSTR=sonucYazisi.getText();
         String arananKelime="Java";

         Assert.assertTrue(sonucYazisiSTR.contains(arananKelime));

         Thread.sleep(5000);



















     }
}
