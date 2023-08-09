package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        String dosyaYOLU="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYOLU);
        Workbook workbook= WorkbookFactory.create(fis);

        //Adimlari takip ederek 1.satira kadar gidelim
        //5.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //2. satir nufus kolonuna 150000 YAZDIRALIM
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("150000");

        // 10.SATIR NUFUS KOLONUNA 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");

        //15. satir nufus kolonuna 5400 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("540000");

        //dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYOLU);
        workbook.write(fos);

        //dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();

    }
}
