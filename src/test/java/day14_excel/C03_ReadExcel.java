package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExceltesti() throws IOException {
        //input olarak verilen satir no, sutun no degerlerini parametre olarak alip
        //0 Cell'deki datayi String olarak bana donduren bir method olusturun

        int satirNo = 4;
        int sutunNo = 4;

        //donen String'in Cezayir oldugunu test edin
        String expectedData = "Cezayir";

        String actualData = banaDataGetir(satirNo - 1, sutunNo - 1);//cunku excel index ile calisir
        Assert.assertEquals(expectedData,actualData);//bu islemi en son yaptik
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {//daha anlasilir olmasi icin i nin isimlerini degistirdik satirIndex ve sutunIndex olarak
        String istenenData = "";//ve string oalrak bize dondurmesini istedigimiz icin void yerine String yaptik 21'de.
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();


        return istenenData;
    }
}
