package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcel() throws IOException {//ingilizce baskentler sutununu yazdiralim

        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi olusturup  parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak FileInputStream objesi girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //ingilizce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();//son satir numarasini aldik getLastRowNum yardimiyla sonra sonsatir'a atadik
        System.out.println(sonSatir);
        String satirdakiData="";

        for (int i = 0; i <sonSatir ; i++) {
            satirdakiData=C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }




    }
}
