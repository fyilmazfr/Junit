package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    WebDriver driver ;

    //bir class olusturun ;checkBoxTest
    //gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com");
        //checkbox1 ve chechBOx2 elementlerini locate edin
        WebElement checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'])[1]"));
        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'])[2]"));

        //checkbox1 secili degilse onay kutusunu tiklayin
       // Thread.sleep(3000);

        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        //CheckBox2 secili degilse onay kutusunu tiklayin
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }

}
