package com.poc.steps;

import com.poc.utility.XLXSReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestSteps {
    XLXSReader xlxsReader = new XLXSReader();
    @Then("I write results to excel")
    public void iWriteResultsToExcel() {
    }

    @Given("I read customerId from excel")
    public void iReadCustomerIdFromExcel() {
        xlxsReader.ExcelXLSReader("src/test/resources/testData/DomainsJourneyMockData.xlsx");

        //This method read data from excel sheet  write data to a given column number
        xlxsReader.getCellData("Sheet1", 201);

        //below method need api response details to run
        xlxsReader.verifyCustomerDetails("Sheet1", 201);
    }

    @And("I search for customer in UI")
    public void iSearchForCustomerInUI() {
    }

    @And("I verify customer details")
    public void iVerifyCustomerDetails() {
    }
}
