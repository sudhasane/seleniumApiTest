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

    }

    @And("I search for customer in UI")
    public void iSearchForCustomerInUI() {
    }

    @And("I verify customer details")
    public void iVerifyCustomerDetails() {
        xlxsReader.ExcelXLSReader("src/test/resources/testData/DomainsJourneyMockData.xlsx");

        int columnNum = xlxsReader.getCellNumber("Sheet1", "Actual Stage" );
        xlxsReader.getCellData("Sheet1", columnNum);

        //below method would fail as get response from api to get expected result is not implemented)
        xlxsReader.verifyCustomerDetails("Sheet1", columnNum);
    }
}
