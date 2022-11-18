package com.poc;

import com.poc.utility.ExcelReading;
import com.poc.utility.GetCustomerDetails;
import com.poc.utility.XLXSReader;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.IOException;


public class Test1 {
XLXSReader xlxsReader = new XLXSReader();
GetCustomerDetails getCustomerDetails = new GetCustomerDetails();

    @Test
    public void testBrowser() throws IOException, BiffException, WriteException {
        ExcelReading excelReading = new ExcelReading();
        excelReading.readExcel();
    }

    @Test
    public void verifyXLXS(){
        xlxsReader.ExcelXLSReader("src/test/resources/testData/DomainsJourneyMockData.xlsx");
        xlxsReader.getCellData("Sheet1", 2);
        xlxsReader.verifyCustomerDetails("Sheet1", 2);
        
    }




}
