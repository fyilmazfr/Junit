package day11_faker_file;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01(){
        //bu soruda iki kere asagi inip video'yu calistirdigimizi tzst ettik

        driver.get("https://html.com/tags/iframe/");

        //video'yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).//klavyede sayfayi gordukten sonra bir kere asagi tusuna basariz ki videoya dogru ilerleyelim
                sendKeys(Keys.PAGE_DOWN).perform();//bu hareketi iki kere yapmamiz lazim


        //video'yu izlemek icin play tusuna basin
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));//video icin bir iframe locate ettik
        driver.switchTo().frame(iframe);//iframe'e gecmemiz lazim
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

    }
}
