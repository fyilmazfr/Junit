package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasindaki tum verileri class'imiza
        // alip bir java objesine store edelim
        //boylece her seferinde excele ulasip satir sutun vs... ugrasmayalim


        //database yapisinda olan excel'i koyabilecegimiz en uygun java objesi Map tir

        Map<String,String> ulkelerMap= new HashMap<>();

        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi olusturup  parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak FileInputStream objesi girelim
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();


        for (int i = 0; i <=sonSatirIndex ; i++) {
            //key i.satirda ki 0 index'indeki data olacak
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i. satirdaki 1,2,3.  index deki datalarin birlesimi olacak
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + ", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value); // BUNU MAP'E ATTIK



        }
        System.out.println(ulkelerMap);

        //liste de Gana  ULKESININ oldugunu test edelim

        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));

    }
}
