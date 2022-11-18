package com.poc.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetCustomerDetails {

    public String getActualResult(String customerid){
        RestAssured.baseURI = "https://";

       return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(customerid).then().log().all().extract().response().path("").toString();

    }
}
