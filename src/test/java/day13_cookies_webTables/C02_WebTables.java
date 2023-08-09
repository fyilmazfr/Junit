package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    // BU SITE KULLANILMIYOR !!!!!

    @Test

    public void webTableTest01(){
        girisYapLogin();
        //login () methodu olusturun ve oturum acin   //bunu web tablosuyla ilgisi yok ayri bir yerde login methodu olusturmak lazim

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



        //TUM TABLE'in boyutunu (sutun sayisini) bulun
        List<WebElement> sutunBasliklariListesi=driver.findElements(By.xpath(""));
        System.out.println("sutun sayisi :"+ sutunBasliklariListesi.size());

        //table'daki tum body'i ve basliklari(headers) konsolda yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());//tum body bir string olarak yazdirmak icin body webelementi'ni locate edip, getText() methodu ileyazdirabilirsiniz

        //table body'sinde bulunan toplam satir(row) sayisini bulun
        List<WebElement> satirlarListasi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi :"+satirlarListasi.size());

        //table body'sinde bulunan satirlari konsolda yazdirin
        for (WebElement each:satirlarListasi) {// 45. satirda zaten satirlari Liste donusturmustuk
            System.out.println(each.getText());

        }
        //4. satirda ki (row) elementleri konsolda yazdirin
        List<WebElement> cellHucreList=driver.findElements(By.xpath("//tbody//tr[4]td"));// body'de ki 4.satir tum sutun bilgileri
        for (WebElement each:cellHucreList) {
            System.out.println(each.getText());

        }

        //email basliginda ki tum sutunlari(elementleri)
        List<WebElement> basliklar=driver.findElements(By.xpath("//thead//tr[1]//th"));// basliklarin listesini verdi
        int emailsutunNo=0;
        for (int i = 0; i <basliklar.size() ; i++) {
            if (basliklar.get(i).getText().equals("Email")){//biz buraya hangi basligi yazarsak onu getirir
                emailsutunNo=i;

            }

        }
        List<WebElement> emailsutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailsutunNo+1)+"]"));
        for (WebElement each:emailsutunListesi) {
            System.out.println(each.getText());

        }//not;WEB table index'i 1 den baslar ,bizim normal javada ogrendigimiz index 0'dan basladigi icin +1 ekledik 71.satirda



    }







}
