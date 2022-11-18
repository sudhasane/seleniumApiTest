package com.poc.UI;

import com.poc.utility.DriverUtils;
import org.openqa.selenium.By;

import static com.poc.steps.CucumberHooks.driver;
import static com.poc.utility.TestConstants.url;

public class SearchRecords extends DriverUtils {
    public static By userid = By.id("");
    public static By searchResult = By.id("");

    public boolean searchUserId(String userId){
        driver.get(url);
        sendKeys(userid, userId);
        if(findElements(searchResult).size()==1){
            return true;
        }

        return false;
    }
}
