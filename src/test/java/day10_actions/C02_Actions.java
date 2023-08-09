package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon ana sayfaya gidip account menusunden create a list linkine tiklayalim
        driver.get("https://www.amazon.fr");
        Actions actions=new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(accountLinki).perform();//bu satir mause satiri dir

        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();


        //Thread.sleep(5000);

    }
}
