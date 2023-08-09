package day11_faker_file;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine git
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile Butonuna basalim
        //yuklemek istedigimiz dosyayi secelim


        /*
        bu islemi selenium ile yapma sansimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() kullaniriz
        eger choosefile butonuna var olan bir dosynain dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir

         */
        //1;adim choosefile butonunu locate edelim
        WebElement dosyasecButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));
        //2.adim yuklenecek dosyanin dosya yolunu olusturlaim

        String farkliKisim=System.getProperty("user.home");
        String ortakkisim="/Desktop/text.txt ";
        String yuklenecekDosya=farkliKisim+ortakkisim;

        //3.adim sendKeys yoluyla dosya yolunu secme butonuna yollayalim
        dosyasecButonu.sendKeys(yuklenecekDosya);
        Thread.sleep(5000);


        //upload butonuna basalim
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //"File Uploaded!" textinin goruntulendigini test edelim
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());


    }
}
