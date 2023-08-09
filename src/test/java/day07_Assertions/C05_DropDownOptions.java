package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon anasayfasina gidip dropdown menuden books'u secelim
     sectigimiz options'u yazdiralim

     dropdown'daki optionslarin toplam sayisinin 47 oldugunu test edin
     */
    WebDriver driver;//Instance variable
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
    public void test01(){
        driver.get("https://www.amazon.fr");
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Livres");


        //bir ddm ile calisiyorken son secilen options'a ulasmak isterseniz getFirstSelectedOption() methodunu
        //kullanmazsiniz bu method bize webElement dondurur uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir
        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown'daki optionslarin toplam sayisinin 28 oldugunu test edin
       List<WebElement> oPTIONlist= select.getOptions();//web elementlerden olusan bir List olusturduk.cunku get options bize liste donduruyor

        int actualoptionsSayisi=oPTIONlist.size();
        int expectedOptionssayisi=47;

        Assert.assertEquals(expectedOptionssayisi,actualoptionsSayisi);

    }
}
