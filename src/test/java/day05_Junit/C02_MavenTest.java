package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // SORU;  http://zero.webappsecurity.com SAYFASINA GIDIN
        driver.get("http://zero.webappsecurity.com");
        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //password alanina "password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //sign in butonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        // online bank menusunden pay bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking'][1]")).click();
        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        //amaount kismina yatirmak istedigimiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        //tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //pay butonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test Passed");
        }else {
            System.out.println("test failed");
        }
        driver.close();

    }
}
