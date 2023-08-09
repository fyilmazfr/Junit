package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //facebook'a git
        driver.get("https://facebook.com");
        //yeni kayit butonuna bas
        driver.findElement(By.xpath("//*[text()='Autoriser tous les cookies']")).click();//cookies butonunu click ettik
        driver.findElement(By.xpath("//*[text()='Créer nouveau compte']")).click();

        // ISIM kutusunu locate et

        WebElement isimkutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        //GERIYE KALAN ALANLARI TAB ile dolasarak

        //formu doldurun

        Actions actions=new Actions(driver);
        actions.click(isimkutusu).sendKeys("TAHA")
                .sendKeys(Keys.TAB)
                .sendKeys("USTAOGLU")
                .sendKeys(Keys.TAB)
                .sendKeys("thausta@gmail.com").perform();


    }
}
