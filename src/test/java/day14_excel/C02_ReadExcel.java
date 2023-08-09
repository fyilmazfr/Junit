package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {//burda kisa yolu gosteriyoruz 27.satirdan itibaren
    @Test
    public void readExcelTest() throws IOException {
        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi olusturup  parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak FileInputStream objesi girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi olusturun
        //Row objesi olusturun
        //Cell objesi olusturun

        String actualData=workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();

    }
}
