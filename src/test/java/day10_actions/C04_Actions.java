package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        //drag me" butonunu tutup "drop here" kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakElemanDRAG= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElemeentDROP=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacakElemanDRAG,hedefElemeentDROP).perform();

        //drop here" yazisi yerine Dropped! oldugunu test edin
        WebElement sONUCYaziElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=sONUCYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }

}
