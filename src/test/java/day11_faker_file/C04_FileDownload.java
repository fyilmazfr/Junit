package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //test packagenin altina bir class olusturalim
        //https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");

        //dummy.txt dosyasini indirelim
        WebElement dummylinki= driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummylinki.click();
        Thread.sleep(5000);//indirme bir sure alacagi icin biraz burda beklememizde yarar var

        //dosyanin basarili bir sekilde inip inmedigini test edin
            //dosya download'a indirilecektir,bize downloads'un dosya yolu lazim
        String farkliKisim=System.getProperty("user.home");
        String ortakKIsim="\\Downloads\\dummy.txt";

        String arananDosyayolu=farkliKisim+ortakKIsim;

           //geriye o dosya yolundaki dosyanin var oldugunu assert edecegiz
        Assert.assertTrue(Files.exists(Paths.get(arananDosyayolu)));

    }


}
