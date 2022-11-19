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
        xlxsReader.ExcelXLSReader("/home/sudhas/Downloads/TestPoi.xlsx");
        int columnNumber = xlxsReader.getColumnNumber("Sheet1", "Result");
        xlxsReader.getCellData("Sheet1", columnNumber);


        //xlxsReader.verifyCustomerDetails("Sheet1", 201);
        
    }




}
