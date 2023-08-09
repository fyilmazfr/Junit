package day13_cookies_webTables;

import org.apache.hc.client5.http.cookie.SetCookie;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTesti() {
        driver.get("https://www.amazon.com");
        //TUM cookiesleri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();// once get c ile cookileri aldik ve bunu Set'e atadik ismide cookieSet yaptik
        System.out.println(cookiesSet);//bunu da soutla gorelim VE hatta terminalde daha iyi gorebilmemiz icin for eachle yazdiralim asgiya

        int sayac = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(sayac + ". cookie " + each);
            sayac++;
        }


        //sayfadaki cookies sayisinin 5ten buyuk oldugunu test edin
        int cookiesSayisi = cookiesSet.size();
        Assert.assertTrue(cookiesSayisi > 5);

        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookiesSet) {

            if (each.getName().equals("i18n-prefs"))
            {
                Assert.assertEquals("USD", each.getValue());

            }
            //ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya
            Cookie cokie=new Cookie("en sevdigim cookie","cikolatali");
            driver.manage().addCookie(cokie);//burada yeni bir cookie olusturduk ve onu amazona ekledik

            sayac = 1;   //sayaci yeniden 1e getirdik cunku yeni cookiden sonra listede artis olacak
            cookiesSet=driver.manage().getCookies(); //eski cookileri getiridk

            for (Cookie each1 :cookiesSet) {

                System.out.println(sayac + ". cookie " + each);
                sayac++;
            }


            //eklediginiz cookie'nin sayfaya eklendigini test edin
            Assert.assertTrue(cookiesSet.contains(cokie));


            //ismi skin olan cookie'yi silin ve silindigini tets edin
            driver.manage().deleteCookieNamed("skin");
            Assert.assertFalse(cookiesSet.contains("skin"));


            //tum cookie'leri silin ve silindigini test edin
            driver.manage().deleteAllCookies();
            cookiesSet=driver.manage().getCookies();
            Assert.assertTrue(cookiesSet.isEmpty());

        }
    }
}
