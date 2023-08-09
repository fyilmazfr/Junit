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

public class C03_RadioButton {
    WebDriver driver;

    //bir class olusturun : radiobuttontest
    //gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin
    @Before
    public void setUp(){
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
    public  void test01(){
        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //cookies'i kabul edin eger istiyorsa
       // driver.findElement(By.xpath("//button[@id='u_0_k_1D']")).click();// BIZDEN ISTEDI VE KABUL ETTIK

        //create an account butonuna basin
        driver.findElement(By.xpath("//a [@id='u_0_0_CU']")).click();
              //burda id herzaman degistigi icin test gecmiyor bu yuzden //*text() yapmakda fayda var

        //radio buttons" elementlerini locate edin
        WebElement femelebuttons=driver.findElement(By.xpath("//input[@id='u_9_4_y6']"));
        WebElement malebutton=driver.findElement(By.xpath("//input[@id='u_9_5_XC']"));
        WebElement personalisebutton=driver.findElement(By.xpath("//input[@id='u_9_6_Xl']"));
            //burda id herzaman degistigi icin test gecmiyor bu yuzden //*text() yapmakda fayda var

        //secili degilse cinsiyet butonundan size uygun olani secin
        if (!malebutton.isSelected()){
            malebutton.click();
        }
        //Thread.sleep(3000);





    }


}
