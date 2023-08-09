package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";// resoursa gidip ordan copy path yaptik
        //FileInputStream objesi olusturup  parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak FileInputStream objesi girelim
        Workbook workbook= WorkbookFactory.create(fis);// calisma kitabimizi olusturduk bundan sonra tum calismamizi burdan devam edecegiz

        //Sheet objesi olusturun
        Sheet shett= workbook.getSheet("Sayfa1");// simdi sayfanin icine girdik

        //Row objesi olusturun
        Row row=shett.getRow(3); //row objesi olusturduk, 3.ucu satiri bize getirsin

        //Cell objesi olusturun
        Cell cell=row.getCell(3);

        System.out.println(cell);//index' 0 dan baslar

        //3.INDEX'deki satirin 3.index'indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();

        Assert.assertEquals(expectedData,actualData);


    }
}
