package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {//hemen extends yapariz before ve after class'lar icin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);//actions hareketi yapmak icin 3 adimimiz var
        WebElement cizgiliAlanElementi=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlanElementi).perform();//sag click yaptik

        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();// once driver'imizi alert'e gecirmemiz ve ardindan da gettext yapip uzerindeki yaziyi almamiz lazim
        Assert.assertEquals(expectedYazi,actualYazi);

        //tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();//tamam yazisini kabul edebilmemiz icin tekrar alerte gecip accept yapmaliyiz 23'uncu satirda assert yapmistik burda alert'e gectik tekrar

        //Elemental selenium linkine tiklayalim
             /*buraya tiklyainca yeni bir windows handle yapmamiz gerekecek cunku yeni bir sayfa aciliyor
             BUYUZDEN ,YENI BIR SAYFAYA GECECEGIMIZ ICIN eski sayfanin windowsHANDLE degerini bir yere kaydetmekte
              fayda var geri donebilmemiz icin veya karsilastirma yapabilmek icin

             */
        String ilkSayfaWHdegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti=driver.getWindowHandles();//handles yapiypruz ki IKI SAYFANIN HANDLE DEGERLERINI BIR SETE KOYDUM
        String ikincisayfaWHDegeri="";
        System.out.println(handleSeti);

        for (String each:handleSeti) {
            if (!each.equals(ilkSayfaWHdegeri)) {
                ikincisayfaWHDegeri = each;

            }
        }
            //acilan sayfada h1 taginda "elemental selenium" yazdigini test edelim
            driver.switchTo().window(ikincisayfaWHDegeri);
            Thread.sleep(3000);
            WebElement yaziElementi= driver.findElement(By.xpath("//img[@class='themedImage_ToTc themedImage--light_HNdA']"));
            String expectedikinciYazii="Elemental Selenium Logo";
            String actualIkinciYazi=yaziElementi.getText();
            Thread.sleep(3000);
            Assert.assertEquals(expectedikinciYazii,actualIkinciYazi);


        }






    }



