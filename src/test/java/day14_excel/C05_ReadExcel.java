package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel { //satir sayisinin 24, kullanilan satir sayisinin ise 12 OLDUGUNU test edin


    @Test
    public void readExcelTesti() throws IOException {
        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi olusturup  parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak FileInputStream objesi girelim
        Workbook workbook= WorkbookFactory.create(fis);


        //sayfa 2 ye gidip
        //satir sayisinin 24, kullanilan satir sayisinin ise 12 OLDUGUNU test edin

        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedSATIRsayisi=24;
        Assert.assertEquals(expectedSATIRsayisi,sonSatirIndex+1);

        int kullanilanSatirSaysi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();//   kullanilanSatirSaysi=getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=12;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSaysi);





    }
}
