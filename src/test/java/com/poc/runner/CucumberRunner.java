package com.poc.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features"
        }, monochrome = true,
        tags = "@test",
        glue = {"com.poc.steps", }

)
public class CucumberRunner {
}
