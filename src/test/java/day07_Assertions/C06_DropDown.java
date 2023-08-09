package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    /*
    https://the-internet.herokuapp.com/dropdown adresine gidin
    1.index kullanarak secenek 1'i(option 1) secin ve yazdirin
    2. Value kullanarak secenek 2'yi (option 2) secin ve yazdirin
    3;visible text(gorunen metin)kullanarak secenek 1'i (option 1) secin ve yazdirin
    4. tum dropdown degerleri (value)yazdirin
    5.dropdown'un BOYUTUNU bulun,dropdown'da 4oge varsa konsolda True, degilse False yazdirin
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropdownMenu);

        //1.index kullanarak secenek 1'i(option 1) secin ve yazdirin
        select.selectByIndex(1);//index ile 1.siradakini sectik
        System.out.println(select.getFirstSelectedOption().getText());//bir onceki adimda sectigimizi yazdirdik

        //2. Value kullanarak secenek 2'yi (option 2) secin ve yazdirin
        select.selectByValue("2");//value deger olarak 2 belirtilmis bizde bunu direk yazdik
        System.out.println(select.getFirstSelectedOption().getText());//bir onceki adimdakini yazdir


        //3. visible text(gorunen metin)kullanarak secenek 1'i (option 1) secin ve yazdirin
        select.selectByVisibleText("Option 1");//gorunen ismi ile aldik
        System.out.println(select.getFirstSelectedOption().getText());//bir onceki islemi yazdirdik

        //4. tum dropdown options'i yazdirin
        List<WebElement> tumOptionslar=select.getOptions();
        for (WebElement each:tumOptionslar) {//web elementdeki tum optionslari yazdiriyoruz for each sayesinde
            System.out.println(each.getText());

        }
        //5.dropdown'un BOYUTUNU bulun,dropdown'da 4oge varsa konsolda True, degilse False yazdirin
        int ddBoyut=tumOptionslar.size();//boyut bulduk
        if (ddBoyut==4){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }


}
