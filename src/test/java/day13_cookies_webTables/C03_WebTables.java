package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici () {
        //onceki class'daki adrese gidip
        //giris yap methodunu kullanarak sayfaya giris yapin
        //input olarak verilen satir ve sutun saysina sahip
        // cell'deki text'i yazdirin

        int satir=3;
        int sutun=5;
        girisYapLogin();


       // C02_WebTables obj=new C02_WebTables();
        //obj.girisYapLogin(); //obje olusturarak C02 class'indan methodu cagirdik

        WebElement ucuncuSatirBesinciSutun= (WebElement) driver.findElements(By.xpath("//tbody//tr["+satir+"]td["+sutun+"]"));
        System.out.println(ucuncuSatirBesinciSutun.getText());



        }
    public void girisYapLogin() {
        driver.get("https://www.hotelmycap.com");
        driver.findElement(By.linkText("Log in")).click();//log in'e tikladik
        Actions actions=new Actions(driver);// otomatik gecisler icin actions objesi olusturmamiz gerekir
        WebElement username= driver.findElement(By.id("UserName"));
        actions.click(username)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1")
                .sendKeys(Keys.ENTER)
                .perform();






    }}
