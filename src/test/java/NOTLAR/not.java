package NOTLAR;



public class not {
     /*


    ornek soru
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com SAYFASINA GIDIN
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

        ****
       * Mavenin yola cikis amaci proje gelistirmenin kolaylastirilmasi ve birlikte calismanin saglanmasidir

       * MAVEN JAVA projelerinin gelistirilebilmesi icin ihtiyacimiz olan tum tool'lari projemize eklemek update etmek
        versiyonlari degistirmek gibi islemleri kolayca yapmamizi saglayan bir tool'dur

       * maven bu islemleri POOMxml sayesinde saglar
         pomXml e ekleyecegimiz dependicy ler ile istedigimiz her kutuphaneyi projemize kolaylikla ekleyebiliriz
         bunlari mvnrepository.com'dan bulabiliriz

       * maven bir framework degildir sadece framework'u kolayca olusturmamizi saglayan bir tool'dur. Biz selenium
         dersleri boyunca 3 framework ile calisacagiz
         Junit
         TestNg
         Cucumber

         ****

       * J UNIT
          . java ole en temel framework Junit ile olusturulabilir
          . developerlar'da unit testleri calistirmak icin kullanirlar
          . junit'in ileri surumu oldugundan TestNg framework olusturup kullanacagiz

          *
          selenium da kodlarimizi yazarken @ isareti ile baslayan notasyonlar kullanabiliriz
          bunlar'dan en cok kullanilanlari
          @Test
          @Beforeclass ve  @AfterClass methodlari
          @Before, @After
          @Ignore

          *
          Junit ile main method kullanimini bitiriyoruz
          @Ignore notasyonu ile bazi metodlari test sirasinda calismasini istemiyorsak bunu eklemeliyiz

          ***
          RADIOBUTTON UN OZELLIGI BIR KUTUCUK secildigi zaman digerini secmesidir

          ***
         j unit , assertions(verifications)

           *BELLI KOSULLARI TEST ETMEK ICIN KULLANILIR
           *assert medhodunu secmeden once kiyaslamada bekledigimiz sonucun tru veya false olmasina karar vermeliyiz
           *onemli olan sonucun ne oldugu degil benim bekledigim sonucun tru mu false'mu olmasidir

   ********
   dropDownMenu ornek soru
    amazona gidip  dropdown'dan books secenegini secip java aratalim, ve arama sonuclarinin java icerdigini test edelim


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.fr");
        //dropdown'dan bir option secmek icin 3 adim vardir
        //1- dropdown'i locate edelim
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2- bir select objesi olusturup parametre olarak bir onceki adimda locate ettiginiz ddm'yi girelim
        Select select=new Select(dropDownMenu);

        //3- ddm 'de var olan options olan istedigimiz bir tanesini secelim

              BU 3 YONTEMLE SECEBILIRIZ
        //select.selectByIndex(28);//index'e gore secim yapar
        //select.selectByValue("search-alias=stripbooks");//valu ile secer
        select.selectByVisibleText("Livres");//gorunur isimle seciyor

        //arama kutusuna java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));//"twotabsearchtextbox" arama kutusu kisa yolu
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiSTR=sonucYazisi.getText();
        String arananKelime="Java";

        Assert.assertTrue(sonucYazisiSTR.contains(arananKelime));

        Thread.sleep(5000);
        ***
          Assertions:
* Assertions: selenium'da test edin denilen durumlari Selenium Assert Class'indan hazir methodlarla yapariz
          java'dan kalan if-else ile de test yapilabilir ama junit ve sonra kullanacagimiz TESTNG frameworklari Assert'e
           gore dizayn edilmistir
* Assertions'da oncelikle tstimizde bizden istenenin ne oldugu incelemeliyiz
          -eger bizden istenen iki degerin esitliginin test edilmesi ise assertEquals
          -eger sonucun olumlu olmasi(true) bekleniyorsa assertTrue
          -eger sonucun olumsuz olmasini false bekliyorsak assertFalse
* Assertions'da test failed olunca selenium kodun kalan satirlarini calistirmaz
           if-else kullandigimizda test istenen sonucu yazdirir, testin calismasi durmaz ve testin sonunda kodlar normal
           calisip bittigi icin test PASSED der.

          DropDownMenu acilir menu:
* dropdown bir webelement'den birden fazla option kullanabilmemizi saglar.
          dropdown ile select tag'i birbirinin ayrilmaz parcasidir.
          Bir HTML ogesi select tag'i kullaniyorsa cok buyuk bir ihtimalle dropdown'dir.
          Dropdown'da asil amac  webElementi locate etmek degil dropdown'dan istedigimiz options'u secebilmektir.
          Secme islemi 3 adimda yapilir;
          -dropdown webelementini locate ederiz
          -select class'indan bir obje olusturup parametre olarak dropdown webElementini yazariz
          -Dropdown'dan option secmek icin 3 secenekten birini seceriz ;
             select.selectByIndex(28);
             select.selectByValue();
             select.selectByVisibleText();

* getoption ile de list'de olusturdugumuz optionslari alabiliyoruz
           bunlari da getfirst selectionoptions methoduyla hepsini yazdirabiliyoruz

           ******

                 HANDLE ALLERTS
* Alert kullaniciya bir turlu bilgi vermek veya belirli bir islemi gerceklestirme izni istemek icin ekran
          bildirimi goruntuleyen kucuk bir mesaj kutusudur.uyari amaciyla da kullanilabilir
* herhangi bir veb sitesine gidince veya bir websitesinde gherhangi bir islem yaptigimizda ortaya cikan uyarilara
          alerts diyoruz.

*HTML alert: Eger bir alert inspect yapilabiliyorsa o alert otomastion ile kullanilabilir, bu tur alert'lere HTML alert
          denir  ve bunlar icin eksta bir islem yapmaya gerek yoktur ,tum webelementmler gibi locate edip istedigimiz
          islemleri yapabiliriz.
 *Java script alert: Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir.
         JS alert'ler locate edilmez.seleniumda JS alert'ler icin ozel bir yontem gelistirilmistir

        1- SIMPle alert  ===> driver.switchTo().alert().accept();
        2-Confirmation Alert ===>  driver.switchTo().alert().getText();
                            ===> driver.switchTo().alert().dismiss(); CANCEL ICIN BUNU YAPARIZ
        3- Prompt alert    ===>    driver.switchTo().alert().sendKeys("yilmaz");


                BASIC AUTHENTICATION
                https://the-internet.herokuapp.com/basic_auth
                driver.get(" https://username:password@URL");
                driver.get(" https://admin:admin@the-internet.herokuapp.com/basic_auth");

*APII derslerinde cok kullanilir.
*uygulamalarin haberlesmesini saglar.
*otomasyon ile kullanici adini ve sifreyi vermeden dogrulamayi yapamam,yani yontemi verilmesi lazim
*html kodlari ile yapilabilir
*BU bilgileri hizmeti saglayan web sitesinin bize vermesi gerekir.


                    HANDLE IFRAME
                    https://html.com/tags/iframe/
 *BIR WEBSITESI icinde farkli bir websitesinin ekrani olabilir.VEYA bir html dokumaninin icine yerlestirilmis baska
 bir HTML dokumanidir
 *Disariya gecislerde switchTO kullanmamaiz gerekir
 *
 iframe'den cikmak icin 2komut vardir
      driver.switchTO.parentframe      1 ust seviyedeki frame'e cikartir
      driver.switchTO.defaultContent() en ustteki frame'e cikmak icin kullanilir, anasayfaya cikar

                       HANDLE WINDOWS
* Pencereler arasinda gecis yapmak icin window handle degerini kullaniriz
windown handle; selenium webdriverin web driver objesi baslatildiginda her pencereye verdigi unique alfanumerique
kimlik degeridir ve handlewindown'dan farklidir.

1- icinde oldugumuz sayfanin window handle degerini alma
 ILK SAYAFAYA DONEBILMEK ICIN windowHandle degerini almak gerekir

                    Handle Windows methodlari
1-icinde oldugumuz sayfanin window handle degerini alma
         driver.getWindowHandle();
2- pencereler arasinda gecis yapma(switch)
        driver.switchTo().window(sayfa1handleDEGERI);
3-yeni tab olusturup gecis yapma(switch)
        driver.switchTo().newWindow(WindowType.TAB);
4-yeni window olusturup gecis yapma(switch)
        driver.switchTo().newWindow(WindowType.WINDOW);
5- acik olan pencerelerin window handle degerlerini alma
       driver.getWindowHandles();

                            TESTBASE CLASS
*OOP konseptin kapisini aciyoruz
*before ve after classlari bir kere yapip ve extends yapip kullaniriz
*Utilities(arac gerecler,faydali hizmetler) package'da Testbase'i olustururuz.
   -setUP method
   -reports (raporlar)
   -tearDown method
                          Actions Class
* Klavye ve mousla yapabildigimiz tum islemleri selenyumda yaptirabiliriz hazir methodlarla.

1.adim; actions classda bir obje olusturulur
Actions actions=new actions(driver);

2.adim; uzerinde calismak istedigimiz Web element ogesini bulmak
WebElement element=driver.findElement(BY.id("ID"));

3.adim ardindan bu element uzerinde action gerceklestirilir ornegin tiklamak icin
 actions.click(element).perform();//bu kisim mause kismi

*Mouse base action (bazi mause aksiyonlari)
        actions.doubleClick().perform();
        actions.clickAndHold().perform();
        actions.dragAndDrop(xyz).perform();
        actions.contextClick(xyz).perform();
*actions ile baslayan cumlemiz mutlaka perform() ile bitmelidir

*https://demoqa.com/droppabl,     https://demoqa.com/

*     KEYBOARD
Actions actions=new Actions(driver);
        actions.click(aramakutusu).perform();
        actions.keyDown(Keys.SHIFT).perform();//buyuk harf
        actions.sendKeys("n").//kucuk n yazdik ama shift'e basili oldugu icin buyuk N yazar arama kutusuna
        keyUp(Keys.SHIFT).//kucuk harf yaptik
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").sendKeys(Keys.ENTER).perform();
*
 Actions actions=new Actions(driver);
        actions.click(isimkutusu).sendKeys("TAHA")
                .sendKeys(Keys.TAB)
                .sendKeys("USTAOGLU")
                .sendKeys(Keys.TAB)
                .sendKeys("thausta@gmail.com").perform();
*
video'yu gorecek kadar asagi inmek
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).//klavyede sayfayi gordukten sonra bir kere asagi tusuna basariz ki videoya dogru ilerleyelim
                sendKeys(Keys.PAGE_DOWN).perform();//bu hareketi iki kere yapmamiz lazim

*  FAKER BILGILER URETMEK
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

                *****
                FILE exist
*biz seleniumda windos uygulamalarini test edemiyoruz ama test etmek icin Java kullanabiliriz
File EXIST yoluyla javadan istifade etcez
*mvnprestrory den file dosyalari kopyaladik


*pc 'de ki bir dosyanin varligini test edebilmemiz icin once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna yani Path'e ihtiyac vardir
        her pc'nin kullanici adi farkli olacagindan masaustu dosyayolu birbirinden farkli olacaktir
        teslerimizin tum pc'lerde calismasi icin dosya yolunu dinamik yapmak zorundayiz

        Bunun icin her pc'nin birbirinden farkli olan yolunu bulmak icin
       String farklikisim= System.getProperty("user.home")

       herkesin pc'sinde ortak olan kisim ise ;
       String ortakKisim=\\Desktop\text.txt

       String masaustudosyYolu=farkliKisim+ortakKisim
        System.out.println(Files.exists(Paths.get(masaustudosyYolu)));

                 SYNCHRONIZATION - SELENIUM WAITS
* ui= kullanici ara yuzu
  problemlerimizin cogunu implictlywait cozer fakat bazen explicit wait kullanmamaiz gerekebilir
* selenium'da senkronizasyonlarimizi wait'lerle saglariz
3 cesit wait vardir thread.sleep ,impmcitywait , explicit wait
* pc'nin hizi , internetin hizi ve server'in yolladigi data larin buyuklugune gore bekleme suremiz degisebilir
* Thread.sleep selenium'un degil Java'nin bekleyicisidir.
*Thread.sleep= Javadan gelir ve kodlari yazilan sure kadar bekletir.sure dolduktan sonra alt satirdan isleme devam eder
*implicitly wait= sayafada ki tum ogeler icin global bir zaman asimidir
*Explicitly Wait(Sartli bekleme)= cogunlukla belirli ogeler icin belirli bir kosul( expected condition) icin kullanilir.ornegin buyuk
  bir dosya indirilmesi gerekiyor.
  1) webdriverWait = (ustteki aciklama)
  2)FluentWait= belli araliklarla kontrol eder ornegin dosyanin indirilmesini her 3 saniye de bir kontrol et gibi

*Explicitly Wait yapmak istersek bir wait objesi olusturmamiz gerekiyor
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));//wait objesi olusturduk
    WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

                            COOKIES
*2 amacli kullanilir server ve kullanici tarafidir.
*amac kucuk bilgileri tutmaktir
*oturum cerezi ve kalici cerez

                             WEB TABLES
                             https://demoqa.com/webtables
*tablo seklinde planlanmis web elementlerdir
*hdml kodlariyla olusturulur
*hdml in onerdigi bir tablo olusturma proseduru vardir
*WebElement ucuncuSatirBesinciSutun= (WebElement) driver.findElements(By.xpath("//tbody//tr["+satir+"]td["+sutun+"]"));
        System.out.println(ucuncuSatirBesinciSutun.getText());
*Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir
 - <table>
 - <header>  tablonun baslik kismini belirler
    <tr> veya <th> satirlari belirler
    <td> satirdaki cell numarasini yani sutun numarasini verir ama web table'de sutun diye bir yapi yok
 -<tbody> tablo body'si
     <tr> satirlari belirler
    <td> satirdaki cell numarasini yani sutun numarasini verir ama web table'de sutun diye bir yapi yok
*Web elementleri absolute xpath'e benzer sekilde locate edebiliriz ancak yaptigimiz tam olarak xpath degildir
  Biz tabloda'ki webelementlerin taglarina odaklaniriz
* mesela tablo body'sin 3.satirin 5. cell'ine ulasmak istersek
   //tbody//tr[3]//td[5]
*mesela basliktaki ilk satirdaki tum datalar //thead//tr[1]
*tablo body'sinde 4.sutunda'ki tum datalar  //tbody//td[4]
*eger verilen satir ve sutun numarasina gore dinamik bir locate yapmak istersek
        //tbody//tr["+satir+"] //td["+sutun+"]

                             EXCEL'in YAPISI
*excel bilgileri saklayabilecegimiz cok minik bir data base dir.
*calisma mantigi once satira git sonra ordan sutuna gec mantigi vardir
*Excel'de bir hucrede bilgiye ulasmak icin dosya/sayfa/satir/sutun/ sirasiyla ilerlemeliyiz
*ewcel'de sutun yapisi yoktur ihtiyac duyarsak kodla ,sutunu elde edebiliriz ancak bir dataya ulasmak icin sutun kullanamayiz
*Seleni'um da Workbook excel dosyamiz var
 Sheet her acik excel sekmesi(Sheet1, Sheet2,etc)
 Row(satir) java yalnizca icerde veri varsa satirlari sayar. default olarak ,java perspektifinden satir sayisi 0'dir
 Cells(hucre) java her satira bakar ve yalnizca hucrede veri varsa hucre sayisini sayar
* Apache POI , microsoft ofis dokumanlarina erismek icin kullanilan Java API'idir
  Poi.apache.com sayfasindan dependincy dosyalari istenilir

* String expectedData="Cezayir";
        String actualData=cell.toString();

        Assert.assertEquals(expectedData,actualData);

*day14 C03 guzel bir soru ornegi bak!
* kullanilanSatirSaysi=getPhysicalNumberOfRows();
*database yapisinda olan excel'i koyabilecegimiz en uygun java objesi Map tir

                                   GetScreenShot
*
 WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazielementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");//kalici dosya
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);//gecici dosya

        FileUtils.copyFile(temp,sonucYazielementSS);


                         JavaScprit executors
*bazen locate alamadigimiz webElement olabilir ,ihtimal, bu durumda javascpritexcuter kullaniriz
*ScroolIntoView
*       //asagida ki sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;   //cast yaptik
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        //sign in butonuna js ile clik yapalim
        jse.executeScript("arguments[0].click",signInButonu);


                            TEST NG
                            YENI BIR PROJE OLUSTURDUK ORDAN DEVAM EDIYORUZ***
* sadece Java ile calisir JDK 7 ve daha ust versiyonlari gereklidir
*test case lerimizi daha basit olarak dizayn etmemizi saglar
*AYni anda farkli browser calistirabiliriz
*rapor alabiliriz test ng sayesinde
































      */

}




















