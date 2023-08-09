package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_tumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {//amazon sayfasina gidip tum sayfanin fotosunu cekelim
        //ve sonrasin da dinamik yapalim yani tarih ekleyelim ki resimler kaybolmasin

        driver.get("https://www.facebook.com");

        TakesScreenshot ts=( TakesScreenshot) driver;//burada cast yaptik

        LocalDateTime date=LocalDateTime.now(); //ve sonrasin da dinamik yapalim yani tarih ekleyelim ki resimler kaybolmasin

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);


        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa.jpeg");//target'in altina ekran goruntuleri diye bir dosya olusturduk
                                                         //tum sayfanin goruntusunu alacagimiz icin ,ve uzantisinida jpeg yaptik

        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);//gelen resmi gecici bir file'a assign ettik
        FileUtils.copyFile(geciciDosya,tumSayfaResim);// kaydettigimiz goruntuyu saklamak istedigimiz dosyaya kopyalayalim,hedef dosyamiz tumsayfaresim



    }
}
