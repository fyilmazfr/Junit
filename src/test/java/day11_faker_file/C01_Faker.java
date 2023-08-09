package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01(){
        //facebook gorevini fake isimlerle yapalim
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
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
        actions.click(isimkutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                 .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();
    }
}
