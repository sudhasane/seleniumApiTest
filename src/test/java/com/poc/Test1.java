package com.poc;

import com.poc.UI.SearchRecords;
import com.poc.utility.ExcelReading;
import com.poc.utility.XLXSReader;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static com.poc.utility.DriverSetup.driver;

public class Test1 {
XLXSReader xlxsReader = new XLXSReader();


    @Test
    public void testBrowser() throws IOException, BiffException, WriteException {
        SearchRecords searchRecords = new SearchRecords();
        ExcelReading excelReading = new ExcelReading();
        //excelReading.readExcelFromExisting();
        excelReading.readExcel();
    }

    @Test
    public void verifyXLXS(){
        xlxsReader.ExcelXLSReader("/home/sudhas/Downloads/DomainsJourneyMockData.xlsx");
        xlxsReader.getCellData();
    }




}
