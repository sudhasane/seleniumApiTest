package com.poc.utility;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReading {
    public WritableWorkbook wwbCopy;
    WritableSheet shSheet;
    Workbook wbook;

    public void readExcel() throws IOException, BiffException, WriteException {
        String fileName = "src/test/resources/testData/DomainsJourneyMockData.xls";
        Workbook workbook = null;
        String customerId;
        String expectedResult;
        wbook = Workbook.getWorkbook(new File(fileName));
        wwbCopy = Workbook.createWorkbook(new File("src/test/resources/testData/DomainsJourneyMockDataCopy.xls"), wbook);
        shSheet = wwbCopy.getSheet(0);

        try {
            workbook = Workbook.getWorkbook(new File(fileName));
        } catch (IOException | BiffException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet(0);

        int rows = sheet.getRows();
        for (int i = 1; i < rows; i++) {
            customerId = sheet.getCell(0, i).getContents();
            expectedResult = sheet.getCell(201, i).getContents();
            System.out.println("customer Id is " + customerId);
            System.out.println("expected result is " + expectedResult);
            Label labTemp = new Label(201, i, "Actaul result");
            shSheet.addCell(labTemp);
        }
        wwbCopy.write();
        wwbCopy.close();
        wbook.close();
    }


}
