package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println( System.getProperty("user.dir"));//C:\Users\fylmz\IdeaProjects\fatihTestNG
        //bana icinde  oldugum projenin dosya yolunu(path) verir.

        System.out.println(System.getProperty("user.home"));//C:\Users\fylmz
        //yani benim bilgisayarimin bana ozel kismini verdi

        //homePath+"/Downloads"


        //masa ustumuzdeki text dosyasinin varligini test edin
        //"C:\Users\fylmz\OneDrive\Masaüstü\text.txt"
        String dosyaYolu=System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        pc 'de ki bir dosyanin varligini test edebilmemiz icin once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna yani Path'e ihtiyac vardir
        her pc'nin kullanici adi farkli olacagindan masaustu dosyayolu birbirinden farkli olacaktir
        teslerimizin tum pc'lerde calismasi icin dosya yolunu dinamik yapmak zorundayiz
        Bunun icin her pc'nin birbirinden farkli olan yolunu bulmak icin
       String farklikisim= System.getProperty("user.home")

       herkesin pc'sinde ortak olan kisim ise ;
       String ortakKisim=\\Desktop\text.txt

       String masaustudosyYolu=farkliKisim+ortakKisim

         */

        String farklikisim= System.getProperty("user.home");//herkesin ortak olan kismi
        String ortakKisim="\\Desktop\\text.txt";//herkesin farkli olan kismi

        String masaustudosyYolu=farklikisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaustudosyYolu)));
       // Assert.assertTrue(Files.exists(Paths.get(masaustudosyYolu)));
    }
}
